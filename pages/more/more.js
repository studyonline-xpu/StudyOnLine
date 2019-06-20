//logs.js
var util = require('../../utils/util.js')
var app = getApp()
Page({
  data: {
    motto: 'Hello World',
    userInfo: {}
  },
  //事件处理函数
  bindViewTap: function() {
    wx.navigateTo({
      url: ''
    })
  },
  onLoad: function () {
    var that = this
    //调用应用实例的方法获取全局数据
    app.getUserInfo(function(userInfo){
      //更新数据
      that.setData({
        userInfo:userInfo
      })
    })
  },
  cd: function(e) {
    var directory = e.currentTarget.dataset.directory
    var url = '../' + directory + '/' + directory;
    wx.navigateTo({
      url: url,
    })
  },
  showDetailInfo: function () {
    var _this = this;
    wx.navigateTo({
      url: '../myInfo/myInfo?userInfo=' + JSON.stringify(this.data.userInfo),
    })
  }
})