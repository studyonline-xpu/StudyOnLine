// pages/test/test.js
// 随机获取颜色
function getRandomColor() {
  let rgb = []
  for (let i = 0; i < 3; ++i) {
    let color = Math.floor(Math.random() * 256).toString(16)
    color = color.length == 1 ? '0' + color : color
    rgb.push(color)
  }
  return '#' + rgb.join('')
}
Page({

  /**
   * 页面的初始数据
   */
  videoContext:'',
  currentTime: '',
  data: {
    inputValue: '',
    danmuList: [
      {
        text: '666666666666',
        color: '#f0f',
        time: 1
      },
      {
        text: '切',
        color: '#ff0',
        time: 2
      },
      {
        text: '嗯？',
        color: '#0ff',
        time: 3
      },
      {
        text: '宝贝回家吃饭么',
        color: '#00f',
        time: 4
      }
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.videoContext = wx.createVideoContext('myvideo');
  },
  bindInputBlur: function (e) {
    this.inputValue = e.detail.value
  },
  // 获取当前视频的播放进度
  getCurrentTime: function (e){
     this.currentTime = e.detail.currentTime;
  },
  bindSendDanmu: function () {
    console.log(this.currentTime)
    this.videoContext.sendDanmu({
      text: this.inputValue,
      color: getRandomColor()
    })
    this.setData({
      inputValue: ""
    })
  }
})