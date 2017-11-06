<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2017/9/12
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图片验证</title>
</head>
<body>
    <img src="http://localhost:89/infiltration/js/validateCodeServlet.jpg">

<script>

    var image = document.getElementsByTagName('img')[0];                  //获取到验证码图片
    var canvas = document.createElement('canvas');                        //新建一个canvas
    var ctx = canvas.getContext("2d");                                    //获取2D上下文
    canvas.width = image.width;                                           //设置canvas的宽度
    canvas.height = image.height;                                         //设置canvas的高度
    document.body.appendChild(canvas);                                    //将canvas添加进文档
    ctx.drawImage(image, 0, 0);                                           //将验证码绘制到canvas上
    for (var i = 0; i < 4; i++) {                                         //循环四次,识别四个数字
        var pixels = ctx.getImageData(i+17.5, 3, 9, 16).data;         //按照公式获取到每个数字上的像素点
        var ldString = "";                                                //用来存储明暗值的字符串
        for (var j = 0, length = pixels.length; j < length; j += 4) {                 //每次循环取四个值,分别是一个像素点的r,g,b,a值
            ldString = ldString + (+(pixels[j] * 0.3 + pixels[j + 1] * 0.59 + pixels[j + 2] * 0.11 >= 128));     //灰度化+二值化,但我们并没有真正的处理图像
        }
        console.log(i);
        console.log(ldString);                 //输出存储着明暗值的字符串
    }

    var captcha = "";                         //存放识别后的验证码
    canvas.width = image.width;
    canvas.height = image.height;
    document.body.appendChild(canvas);
    ctx.drawImage(image, 0, 0);
    for (var i = 0; i < 4; i++) {
        var pixels = ctx.getImageData(13 * i + 7, 3, 9, 16).data;
        var ldString = "";
        for (var j = 0,length = pixels.length; j < length; j += 4) {
            ldString = ldString + (+(pixels[j] * 0.3 + pixels[j + 1] * 0.59 + pixels[j + 2] * 0.11 >= 140));
        }
        var comms = numbers.map(function (value) {                      //为了100%识别率,这里不能直接判断是否和模板字符串相等,因为可能有个别0被计算成1,或者相反
            return ldString.split("").filter(function (v, index) {
                return value[index] === v
            }).length
        });
        captcha += comms.indexOf(Math.max.apply(null, comms));          //添加到识别好的验证码中
    }
    console.log(captcha);

</script>
</body>
</html>
