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
      bannerimg:[]
    },
    ad:[],
    hotCourse:[],
    moreCourses:{
      title:"已经到底，查看更多课程 >",
      url:"../course/course"
      },
    userInfo: {}
  },
  /*点击banner上的圆选择相应的图片 */
  bindStlBanner:function(e){
    var that = this;
    var bannerIdx = e.currentTarget.dataset.index;
      clearTimeout(that.data.banner.timeoutProcess);
      that.changeBanner(bannerIdx);
      that.data.banner.timeoutProcess = setInterval(that.timetochange,3000);
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
    that.changeBanner(0);
    //调用应用实例的方法获取全局数据
    app.getUserInfo(function(userInfo){
      //更新数据
      that.setData({
        userInfo:userInfo
      })
    })
    wx.request({
      url: 'http://47.103.101.35:8080/study_online-manager-web/video/queryHotVideo',
      success:function(res){
        var hotCourse = res.data;
        for(var i = 0;i<hotCourse.length;i++){
          var courseInfo = JSON.stringify(hotCourse[i]);
          hotCourse[i].navigate = '../other/other?courseInfo=' + courseInfo
        }
        that.setData({
          hotCourse: hotCourse
        })
      }
    })
  },
  onShow:function(){
    this.onLoad();
    var that = this;
    that.data.banner.timeoutProcess = setInterval(that.timetochange,3000);
  },
  onHide:function(){
    var that=this;
    clearTimeout(that.data.banner.timeoutProcess);
  },
  /**根据bannerArray的index显示 */
  changeBanner:function(index){
    var that = this,
        banner = that.data.banner,
        currindex = banner.currindex;

    banner.bannerimg[currindex].class ='';
    banner.bannerimg[index].class = 'active';
    banner.currindex = index;
    that.setData({
    "banner":banner
    });
    //showImg  todo
  },
  /*轮播banner */
  timetochange:function(){
    var that = this,
        banner = that.data.banner,
        currindex = banner.currindex;
        if(currindex < banner.bannerimg.length - 1)
        {
          currindex ++;
        }else{
          currindex = 0;
        }
        that.changeBanner(currindex);
  }
})
