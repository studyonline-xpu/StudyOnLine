// pages/div/div.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    /* 内容Body数据 */
    // 热门推荐
    hotList: [],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var _this = this;
    wx.request({
      url: 'http://47.103.101.35:8080/study_online-manager-web/video/queryVideoByClassId',
      data: {
        classId: options.classId
      },
      success: function (res) {
        var hotlist = res.data;
        for(var i = 0;i<hotlist.length;i++){
          var courseInfo = JSON.stringify(hotlist[i]);
          hotlist[i].navigate = '../other/other?courseInfo=' + courseInfo;
        }
        _this.setData({
          hotList: res.data
        })
      }
    })
  },
})