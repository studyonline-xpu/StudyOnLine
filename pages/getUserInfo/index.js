const app = getApp();
Page({
  data: {
    //判断小程序的API，回调，参数，组件等是否在当前版本可用。
    canIUse: wx.canIUse('button.open-type.getUserInfo'),
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var _this = this;
    wx.showToast({
      title: '加载中,请稍等',
      icon: 'loading'
    })
    wx.getSetting({
      success: function (e) {
        // 如果已经授权,直接跳转到首页
        if(e.authSetting["scope.userInfo"]) {
          wx.switchTab({
            url: '../index/index',
          })
        }
      }
    })
  },
  bindGetUserInfo: function (e) {
    var _this = this;
    if (e.detail.userInfo) {
      var userInfo = e.detail.userInfo;
      wx.login({
        success(res) {
          if (res.code) {
            //把获取到的code通过一个request的请求发给java服务器
            wx.request({
              url: 'http://47.103.101.35:8080/study_online-manager-web/user/login',
              data: {
                js_code: res.code,
                appid: 'wx9d4a2e112506aa29',
                secret: '85c05d04afb55259c0aa21398268d020',
                imgUrl: userInfo.avatarUrl,
                nickName: userInfo.nickName
              },
              header: { 
                'content-type': 'application/x-www-form-urlencoded;charset=utf-8', 
              },
              method: 'POST',
              dataType: 'json',
              success: function (res) {
                wx.setStorageSync("sessionId", res.data.session_key);
                wx.setStorageSync("openid1", res.data.openid);
                //请求成功的处理
                if (res.data.status == 1) {
                  wx.switchTab({
                    url: '../index/index',
                  })
                }
              },
              fail: function () {
                //请求失败的处理
                console.log("发送code失败：", res.data);
              }
            })
          }
        }
      })
    } else {
      //用户按了拒绝按钮
      wx.showModal({
        title: '警告',
        content: '您点击了拒绝授权，将无法进入小程序，请授权之后再进入!',
        showCancel: false,
        confirmText: '返回授权',
      })
    }
  },
})