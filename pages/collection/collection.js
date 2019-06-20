// pages/div/div.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    /* 内容Body数据 */
    hotList: [],
    showModalStatus: false,
    videoId: ''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var _this = this;
    wx.request({
      url: 'http://47.103.101.35:8080/study_online-manager-web/user/queryCollections',
      data: {
        user_id: wx.getStorageSync("openid1"),
      },
      success: function (res) {
        var hotlist = res.data;
        if (hotlist.length==0){
          wx.showToast({
            title: '暂无数据，去收藏您喜欢的视频吧！',
            icon: 'none'
          })
        }else{
          for (var i = 0; i < hotlist.length; i++) {
            var courseInfo = JSON.stringify(hotlist[i]);
            hotlist[i].navigate = '../other/other?courseInfo=' + courseInfo;
          }
        }
        _this.setData({
          hotList: hotlist,
        })
      }
    })
  },
  navigateTo: function (e) {
      var url = e.currentTarget.dataset.url;
      wx.navigateTo({
        url: url,
      })
  },
  cancelCollect: function () {
    var _this = this;
    wx.showModal({
      title: '是否确认移除该收藏',
      success: function (res) {
        if (res.confirm) {
          wx.request({
            url: 'http://47.103.101.35:8080/study_online-manager-web/user/deleteCollections',
            data: {
              user_id: wx.getStorageSync("openid1"),
              video_id: _this.data.videoId
            },
            success: function (res) {
              var hotlist = res.data;
              for (var i = 0; i < hotlist.length; i++) {
                var courseInfo = JSON.stringify(hotlist[i]);
                hotlist[i].navigate = '../other/other?courseInfo=' + courseInfo;
              }
              _this.setData({
                hotList: hotlist
              })
            }
          })
        }
      }
    })
  },
  longpress: function(e) {
    var _this = this;
    var videoId = e.currentTarget.dataset.videoid;
    _this.setData({
      videoId: videoId
    })
    wx.showActionSheet({
      itemList: ['确定取消该视频'],
      success: function (res) {
        if (!res.cancel){
          _this.cancelCollect()
        }
      }
    })
  }
})