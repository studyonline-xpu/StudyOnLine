// pages/other/other.js
Page({
  data:{
    currentIcon:"down.png",
    showModalStatus: false,
    videoUrl:'',
    current: '1',
    current_scroll: '1',
    tab1:true,
    tab2:false,
    tab3:false,
    name: 'name0',
    courseInfo: '',
    good:[
      { name: "likes", value: 123 }, { name: "collection", value: 123 }, { name: "direct", value: 123}
    ],
    cataloge:[],
    conment:[]
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
    var courseInfo = JSON.parse(options.courseInfo);
    var date = new Date(courseInfo.updateTime);
    var showDate = date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate();
    courseInfo.updateTime = showDate;
    var good = _this.data.good;
    good[0].value = courseInfo.likes;
    good[1].value = courseInfo.collections;
    _this.setData({
      courseInfo: courseInfo,
      good: good
    })
    wx.request({
      url: 'http://47.103.101.35:8080/study_online-manager-web/catalog/queryChapters',
      data: {
        video_id: this.data.courseInfo.videoId
      },
      success: function (res) {
        var cataloge = res.data;
        for (var i = 0; i < cataloge.length;i++){
          cataloge[i].name = "name"+i;
        }
        _this.setData({
          cataloge: cataloge,
        })
      }
    })
    wx.request({
      url: 'http://47.103.101.35:8080/study_online-manager-web/comments/queryComments',
      data: {
        father_id: _this.data.courseInfo.videoId
      },
      success: function(res) {
        var list = res.data;
        for (var i = 0; i < list.length;i++){
          var date = new Date(list[i].time);
          var showDate = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
          list[i].time = showDate;
        }
        _this.setData({
          conment: list
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
    var index = e.currentTarget.dataset.index;
    var secondIndex = e.currentTarget.dataset.secondindex;
    _this.setData({
      videoUrl: _this.data.cataloge[index].catalogs[secondIndex].videoUrl
    })
  },
  changeData: function(e){
    var index = e.currentTarget.dataset.index;
    var value = this.data.good[index].value;
    // 点赞
    if(index == 0){
      if (this.data.good[index].name == 'likes'){
        this.setData({
          ["good[" + index + "].value"]: value + 1,
          ["good[" + index + "].name"]: 'likes2'
        })
        wx.request({
          url: 'http://47.103.101.35:8080/study_online-manager-web/video/addLikes',
          data: {
            video_id: this.data.courseInfo.videoId,
          },
          success: function (res) {

          }
        })
      }
    // 收藏
    } else if(index == 1){
      if (this.data.good[index].name == 'collection') {
        this.setData({
          ["good[" + index + "].value"]: value + 1,
          ["good[" + index + "].name"]: 'collection2'
        })
        wx.request({
          url: 'http://47.103.101.35:8080/study_online-manager-web/video/addCollect',
          data: {
            video_id: this.data.courseInfo.videoId,
            user_id: wx.getStorageSync("openid1")
          },
          success: function(res){
            
          }
        })
      }
    // 转发
    } else if(index == 2){

    }
  },
  detailReply: function(e) {
    var conmentId = e.currentTarget.dataset.fatherid;
    wx.request({
      url: 'http://47.103.101.35:8080/study_online-manager-web/comments/queryComments',
      data: {
        father_id: conmentId,
      },
      success: function(res) {
        console.log(res)
      }
    })
  }
})