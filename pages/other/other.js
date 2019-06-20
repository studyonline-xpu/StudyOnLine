// pages/other/other.js
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
  videoContext: '',
  currentTime: '',
  inputValue: '',
  data:{
    currentIcon:"down.png",
    showModalStatus: false,
    videoUrl:'',
    showModalStatus: false,
    current: '1',
    current_scroll: '1',
    catalogId:'',
    tab1:true,
    tab2:false,
    animation2:null,
    tab3:false,
    name: 'name0', 
    courseInfo: '',
    height:'',
    conmentCount:'',
    conmentContent:'',
    good:[
      { name: "likes", value: 0 }, { name: "collection", value: 0 }, { name: "direct", value: 0}
    ],
    cataloge:[],
    conment:[],
    secondConment:[],
    danmuList:[]
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
  // 获取当前视频的时间
  getCurrentTime: function (e) {
    this.currentTime = e.detail.currentTime;
  },
  handleChangeScroll({ detail }) {
    this.setData({
      current_scroll: detail.key
    });
  },
  // 获取弹幕信息
  bindInput: function (e) {
    this.inputValue = e.detail.value
  },
  //发送弹幕
  sendDanmu: function () {
    var time = parseInt(this.currentTime);
    var catalogId = this.data.catalogId;
    var color = getRandomColor();
    this.videoContext.sendDanmu({
      text: this.inputValue,
      color: color
    })
    var barrage = { barrageId: '', msg: this.inputValue, color: color, time: time, catalogId: catalogId};
    wx.request({
      url: 'http://47.103.101.35:8080/study_online-manager-web/barrage/insertBarrage',
      data: {
        barrageJson: JSON.stringify(barrage)
      },
      header: {
        'content-type': 'application/x-www-form-urlencoded;charset=utf-8',
      },
      method:'POST',
      success: function (res) {
        wx.showToast({
          title: '弹幕已送达！',
          icon: 'none'
        })
      }
    })
    this.setData({
      inputValue: ""
    })
  },
  // 查询弹幕
  queryBarrage: function() {
    var _this = this;
    wx.request({
      url: 'http://47.103.101.35:8080/study_online-manager-web/barrage/queryBarrage',
      data:{
        catalog_id: _this.data.catalogId
      },
      success: function(res){
        var list = res.data;
        for(var i = 0;i<list.length;i++) {
          list[i].text = list[i].msg;
        }
        _this.setData({
          danmuList: list
        })
      }
    })
  },
  onLoad:function(options){
    // 初始化video上下文对象
    this.videoContext = wx.createVideoContext('myvideo');
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
        video_id: this.data.courseInfo.videoId,
        user_id: wx.getStorageSync("openid1")
      },
      success: function (res) {
        var cataloge = res.data;
        for (var i = 0; i < cataloge.length;i++){
          cataloge[i].name = "name"+i;
          for (var j = 0; j < cataloge[i].catalogs.length;j++) {
            if(i==0&&j==0){
              cataloge[i].catalogs[j].color = 'green';
            }else{
              cataloge[i].catalogs[j].color = 'black';
            }
          }
        }
        _this.setData({
          cataloge: cataloge,
          ['good[1].name']: cataloge[0].collected ? 'collection2' :'collection',
          videoUrl: cataloge[0].catalogs[0].videoUrl,
          catalogId: cataloge[0].catalogs[0].catalogId
        })
        // 查询弹幕
        _this.queryBarrage();
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
          conment: list,
          conmentCount: list.length
        })
      }
    })
  },
  //切换图表朝向
  change: function (e) {
    var _this = this;
    var thisIcon = _this.data.currentIcon;
    var height = 0;
    let query = wx.createSelectorQuery();
    query.select('.detailDesc').boundingClientRect(rect => {
      height = rect.height;
      if (height != 0) {
        _this.setData({
          height: height
        })
      }
    }).exec();
    /* 动画部分 */
    // 第1步：创建动画实例 
    var animation = wx.createAnimation({
      duration: 200,  //动画时长
      timingFunction: "linear", //线性
      delay: 0  //0则不延迟
    });
    // 第2步：这个动画实例赋给当前的动画实例
    switch (thisIcon){
      case "down.png":{
        thisIcon = "upward.png";
        // 第3步：执行第一组动画
        animation.height(0).step();
        break;
      }
      case "upward.png":{
        thisIcon = "down.png"
        // 第3步：执行第一组动画
        var data = _this.data.height;
        animation.height(data).step();
        break;
      }
    }
    // 第4步：导出动画对象赋给数据对象储存
    _this.setData({
      animation2: animation.export(),
      currentIcon: thisIcon
    })
  },
  // 点击章节切换视频
  changeSource: function (e) {
    var _this = this;
    var index = e.currentTarget.dataset.index;
    var secondIndex = e.currentTarget.dataset.secondindex;
    var cataloge = _this.data.cataloge;
    for (var i = 0; i < cataloge.length; i++){
      for (var j = 0; j < cataloge[i].catalogs.length; j++){
        cataloge[i].catalogs[j].color = 'black';
      }
    }
    cataloge[index].catalogs[secondIndex].color = 'green';
    _this.setData({
      videoUrl: _this.data.cataloge[index].catalogs[secondIndex].videoUrl,
      catalogId: _this.data.cataloge[index].catalogs[secondIndex].catalogId,
      cataloge: cataloge
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
          }
        })
      }
    // 转发
    } else if(index == 2){
      
    }
  },
  getConment: function(e) {
    this.setData({
      conmentContent: e.detail.value
    })
  },
  // 发布评论
  release: function () {
    var _this = this;
    var conment = {};
    conment.msg = _this.data.conmentContent;
    if (conment.msg == '' || conment.msg ==null){
      wx.showToast({
        title: '评论不得为空！',
        icon: 'none'
      })
    }else{
      conment.fromId = wx.getStorageSync("openid1");
      conment.fatherId = _this.data.courseInfo.videoId;
      conment.commentsId = '';
      conment.toId = '';
      conment.isFather = '';
      conment.time = '';
      conment.fromName = '';
      conment.fromPicture = '';
      var conmentString = JSON.stringify(conment);
      wx.request({
        url: 'http://47.103.101.35:8080/study_online-manager-web/comments/insertComments',
        data: {
          commentsJson: conmentString
        },
        header: {
          'content-type': 'application/x-www-form-urlencoded;charset=utf-8',
        },
        method: 'POST',
        success: function (res) {
          _this.setData({
            conmentContent: ''
          })
          wx.showToast({
            title: '评论成功！',
            icon: 'none'
          })
          wx.request({
            url: 'http://47.103.101.35:8080/study_online-manager-web/comments/queryComments',
            data: {
              father_id: _this.data.courseInfo.videoId
            },
            success:function (res) {
              var list = res.data;
              for (var i = 0; i < list.length; i++) {
                var date = new Date(list[i].time);
                var showDate = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
                list[i].time = showDate;
              }
              _this.setData({
                conment: list
              })
            }
          })
        }
      })
    }
  },
  // 二级评论动画
  powerDrawer: function (e) {
    var _this = this;
    if (e.currentTarget.dataset.statu == 'open'){
      var conmentId = e.currentTarget.dataset.fatherid;
      wx.request({
        url: 'http://47.103.101.35:8080/study_online-manager-web/comments/queryComments',
        data: {
          father_id: conmentId,
        },
        success: function (res) {
          var list = res.data;
          for (var i = 0; i < list.length; i++) {
            var date = new Date(list[i].time);
            var showDate = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
            list[i].time = showDate;
          }
          _this.setData({
            secondConment: list
          })
        }
      })
    }
    var currentStatu = e.currentTarget.dataset.statu;
    this.util(currentStatu)
  },
  util: function (currentStatu) {
    /* 动画部分 */
    // 第1步：创建动画实例 
    var animation = wx.createAnimation({
      duration: 200,  //动画时长
      timingFunction: "linear", //线性
      delay: 0  //0则不延迟
    });

    // 第2步：这个动画实例赋给当前的动画实例
    this.animation = animation;

    // 第3步：执行第一组动画：Y轴偏移240px后(盒子高度是240px)，停
    animation.translateY(300).step();

    // 第4步：导出动画对象赋给数据对象储存
    this.setData({
      animationData: animation.export()
    })

    // 第5步：设置定时器到指定时候后，执行第二组动画
    setTimeout(function () {
      // 执行第二组动画：Y轴不偏移，停
      animation.translateY(0).step()
      // 给数据对象储存的第一组动画，更替为执行完第二组动画的动画对象
      this.setData({
        animationData: animation
      })

      //关闭抽屉
      if (currentStatu == "close") {
        this.setData(
          {
            showModalStatus: false
          }
        );
      }
    }.bind(this), 200)
    // 显示抽屉
    if (currentStatu == "open") {
      this.setData(
        {
          showModalStatus: true
        }
      );
    }
  }
})