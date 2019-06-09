Component({
    externalClasses: ['i-class'],

    relations: {
        '../grid/index': {
            type: 'parent'
        },
        '../grid-icon/index': {
            type: 'child'
        }
    },

    data: {
        width: '33.33%'
    },
  //点赞动画
  drawImage: function (data) {
    var that = this
    var p10 = data[0][0];   /* 三阶贝塞尔曲线起点坐标值*/
    var p11 = data[0][1];   /* 三阶贝塞尔曲线第一个控制点坐标值*/
    var p12 = data[0][2];   /* 三阶贝塞尔曲线第二个控制点坐标值*/
    var p13 = data[0][3];   /* 三阶贝塞尔曲线终点坐标值*/

    var p20 = data[1][0];
    var p21 = data[1][1];
    var p22 = data[1][2];
    var p23 = data[1][3];

    var p30 = data[2][0];
    var p31 = data[2][1];
    var p32 = data[2][2];
    var p33 = data[2][3];

    var t = factor.t;

    /*计算多项式系数 （下同）*/
    var cx1 = 3 * (p11.x - p10.x);
    var bx1 = 3 * (p12.x - p11.x) - cx1;
    var ax1 = p13.x - p10.x - cx1 - bx1;

    var cy1 = 3 * (p11.y - p10.y);
    var by1 = 3 * (p12.y - p11.y) - cy1;
    var ay1 = p13.y - p10.y - cy1 - by1;

    var xt1 = ax1 * (t * t * t) + bx1 * (t * t) + cx1 * t + p10.x;
    var yt1 = ay1 * (t * t * t) + by1 * (t * t) + cy1 * t + p10.y;

    var cx2 = 3 * (p21.x - p20.x);
    var bx2 = 3 * (p22.x - p21.x) - cx2;
    var ax2 = p23.x - p20.x - cx2 - bx2;

    var cy2 = 3 * (p21.y - p20.y);
    var by2 = 3 * (p22.y - p21.y) - cy2;
    var ay2 = p23.y - p20.y - cy2 - by2;

    var xt2 = ax2 * (t * t * t) + bx2 * (t * t) + cx2 * t + p20.x;
    var yt2 = ay2 * (t * t * t) + by2 * (t * t) + cy2 * t + p20.y;



    var cx3 = 3 * (p31.x - p30.x);
    var bx3 = 3 * (p32.x - p31.x) - cx3;
    var ax3 = p33.x - p30.x - cx3 - bx3;

    var cy3 = 3 * (p31.y - p30.y);
    var by3 = 3 * (p32.y - p31.y) - cy3;
    var ay3 = p33.y - p30.y - cy3 - by3;

    /*计算xt yt的值 */
    var xt3 = ax3 * (t * t * t) + bx3 * (t * t) + cx3 * t + p30.x;
    var yt3 = ay3 * (t * t * t) + by3 * (t * t) + cy3 * t + p30.y;
    factor.t += factor.speed;
    ctx.drawImage("../../images/heart1.png", xt1, yt1, 30, 30);
    ctx.drawImage("../../images/heart.png", xt2, yt2, 30, 30);
    ctx.drawImage("../../images/heart3.png", xt3, yt3, 30, 30);
    ctx.draw();
    if (factor.t > 1) {
      factor.t = 0;
      cancelAnimationFrame(timer);
      that.startTimer();
    } else {
      timer = requestAnimationFrame(function () {
        that.drawImage([[{ x: 30, y: 400 }, { x: 70, y: 300 }, { x: -50, y: 150 }, { x: 30, y: 0 }], [{ x: 30, y: 400 }, { x: 30, y: 300 }, { x: 80, y: 150 }, { x: 30, y: 0 }], [{ x: 30, y: 400 }, { x: 0, y: 90 }, { x: 80, y: 100 }, { x: 30, y: 0 }]])
      })
    }
  }
});
