//index.js
//获取应用实例
var app = getApp();
var util = require("../../utils/util.js");
Page({
  data: {
    banner:{
      delay:3000,
      timeoutProcess:null,
      currindex:0,
      bannerimg:[],
      keyWords:''
    },
    ad:[],
    begin: 0,
    hotCourse:[],
    hasCourse:true,
    moreCourses:{
      title:"没有喜欢的?换一批试试",
      icon:'../../images/refresh.png'
      },
    userInfo: {}
  },
  onLoad: function () {
    var that = this;
    var bannerArr = util.getBanner(),
        adArr = util.getAd();
    that.setData({
        banner:{
          currindex:0,
          bannerimg:bannerArr
        },
        ad:adArr,
      });
    //调用应用实例的方法获取全局数据
    app.getUserInfo(function(userInfo){
      //更新数据
      that.setData({
        userInfo:userInfo
      })
    })
    wx.request({   
      url: 'http://47.103.101.35:8080/study_online-manager-web/video/queryHotVideo',
      data: {
        begin: that.data.begin
      },
      success:function(res){
        var hotCourse = res.data;
        for(var i = 0;i<hotCourse.length;i++){
          var courseInfo = JSON.stringify(hotCourse[i]);
          hotCourse[i].navigate = '../other/other?courseInfo=' + courseInfo
        }
        that.setData({
          hotCourse: hotCourse,
        })
      }
    })
  },
  onShow:function(){
    this.onLoad();
    var that = this;
    that.setData({
      begin: 0
    })
  },
  refreshResource: function() {
    var that = this;
    wx.request({
      url: 'http://47.103.101.35:8080/study_online-manager-web/video/queryHotVideo',
      data: {
        begin: that.data.begin + 8
      },
      success: function (res) {
        var hotCourse = res.data;
        if(hotCourse.length == 0){
          wx.showToast({
            title: '没有更多数据啦！',
            icon: 'none'
          })
        }else{
          for (var i = 0; i < hotCourse.length; i++) {
            var courseInfo = JSON.stringify(hotCourse[i]);
            hotCourse[i].navigate = '../other/other?courseInfo=' + courseInfo
          }
          that.setData({
            hotCourse: hotCourse,
            begin: that.data.begin + 8
          })
        }
      }
    })
  },
  getKeyWord: function(e){
    this.setData({
      keyWords: e.detail.value
    })
  },
  upper: function () {
    var _this = this;
    wx.navigateTo({
      url: '../search/search?keyWords=' + _this.data.keyWords,
    })
    _this.setData({
      keyWords: ''
    })
  }
})
