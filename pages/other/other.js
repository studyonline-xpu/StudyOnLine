// pages/other/other.js
Page({
  data:{
    currentIcon:"down.png",
    videoUrl:'',
    current: '1',
    current_scroll: '1',
    tab1:true,
    tab2:false,
    tab3:false,
    name: 'name0',
    good:[
      { name: "likes", value: 123 }, { name: "collection", value: 123 }, { name: "direct", value: 123}
    ],
    cataloge:[],
    conment:[
      { img: '', nickname: '刘琪军', time: '2019-09-10', content: '教学很详细，很容易就懂了' },
      { img: '', nickname: '刘琪军', time: '2019-09-10', content: '教学很详细，很容易就懂了' },
      { img: '', nickname: '刘琪军', time: '2019-09-10', content: '教学很详细，很容易就懂了' },
      { img: '', nickname: '刘琪军', time: '2019-09-10', content: '教学很详细，很容易就懂了' },
      { img: '', nickname: '刘琪军', time: '2019-09-10', content: '教学很详细，很容易就懂了' },
      { img: '', nickname: '刘琪军', time: '2019-09-10', content: '教学很详细，很容易就懂了' },
    ]
  },
  handleChange({ detail }) {
    var index = detail.key;
    this.setData({
      current: detail.key
    });
    if (index == 1) {
      this.setData({
        tab1: true,
        tab2: false,
        tab3: false
      })
    } else if (index == 2) {
      this.setData({
        tab1: false,
        tab2: true,
        tab3: false
      })
    } else if (index == 3) {
      this.setData({
        tab1: false,
        tab2: false,
        tab3: true
      })
    }
  },

  handleChangeScroll({ detail }) {
    this.setData({
      current_scroll: detail.key
    });
  },
  onLoad:function(options){
    // 页面初始化 options为页面跳转所带来的参数
    var _this = this;
    wx.request({
      url: 'http://47.103.101.35:8080/study_online-manager-web/catalog/queryChapters',
      data: {
        video_id: options.video_id
      },
      success: function (res) {
        var cataloge = res.data;
        console.log(cataloge)
        for (var i = 0; i < cataloge.length;i++){
          cataloge[i].name = "name"+i;
        }
        _this.setData({
          cataloge: cataloge
        })
      }
    })
  },
  //切换图表朝向
  change: function (e) {
    var _this = this;
    var thisIcon = _this.data.currentIcon;
    switch (thisIcon){
      case "down.png":
        thisIcon = "upward.png";
        break;
      case "upward.png":
        thisIcon = "down.png"
        break;
    }
    _this.setData({
      currentIcon: thisIcon
    })
  },
  changeSource: function (e) {
    var _this = this;
    _this.setData({
      videoUrl: e.currentTarget.dataset.url
    })
  }
})