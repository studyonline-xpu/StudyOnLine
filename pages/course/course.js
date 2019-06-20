// pages/course/course.js
var util = require("../../utils/util.js");
Page({
  data:{
    courses:[],
    detailCourse:[],
    keyWords:''
  },
  onLoad:function(options){
    // 页面初始化 options为页面跳转所带来的参数
    var _this = this;
    wx.request({
      url: 'http://47.103.101.35:8080/study_online-manager-web/videoClass/queryVideoClassByFatherId',
      success: function(res) {
        _this.setData({
          courses: res.data
        })
      }
    })
  },
  // 选择切换
  selectTab:function(e){
    var _this = this,
    index = e.currentTarget.dataset.index,
    coursesArr = _this.data.courses;
    for(var  i = 0;i < coursesArr.length; i++ ){
      coursesArr[i].active = "";//false
    }
    coursesArr[index].active = "true";
    var fatherId = coursesArr[index].classId;
    _this.setData({
      courses:coursesArr
    });
    wx.request({
      url: 'http://47.103.101.35:8080/study_online-manager-web/videoClass/queryVideoClassByFatherId',
      data: {
        fatherId: fatherId
      },
      success: function(res) {
        if (res.data.length == 0 || res.data == null){
          wx.navigateTo({
            url: '../div/div?classId=' + fatherId,
          })
        }
        _this.setData({
          detailCourse: res.data
        })
      }
    })
  },
  // 跳转页面
  navigatorToSourse: function (e) {
    wx.navigateTo({
      url: '../div/div?classId='+e.currentTarget.id,
    })
  },
  getKeyWord: function (e) {
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