// pages/other/other.js
Page({
  data:{
    currentData: 0,
    currentIcon:"down.png",
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
        for (var i = 0; i < cataloge.length;i++){
          cataloge[i].name = "name"+i;
        }
        _this.setData({
          cataloge: cataloge
        })
      }
    })
  },
  //获取当前滑块的index
  bindchange: function (e) {
    const that = this;
    that.setData({
      currentData: e.detail.current
    })
  },
  //点击切换，滑块index赋值
  checkCurrent: function (e) {
    const that = this;
    if (that.data.currentData === e.target.dataset.current) {
      return false;
    } else {
      that.setData({
        currentData: e.target.dataset.current
      })
    }
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
  }
})