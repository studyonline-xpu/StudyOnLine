// pages/div/div.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    /* 内容Body数据 */
    historyList: [],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var _this = this;
    wx.request({
      url: 'http://47.103.101.35:8080/study_online-manager-web/video/searchWithKeyWord',
      data: {
        keyWords: options.keyWords,
      },
      success: function (res) {
        var historyList = res.data;
        if (historyList.length==0){
          wx.showToast({
            title: '没有找到相关资源，去逛一逛吧！',
            icon: 'none'
          })
        }else{
          for (var i = 0; i < historyList.length; i++) {
            var courseInfo = JSON.stringify(historyList[i]);
            historyList[i].navigate = '../other/other?courseInfo=' + courseInfo;
          }
        }
        _this.setData({
          historyList: historyList
        })
      }
    })
  },
})