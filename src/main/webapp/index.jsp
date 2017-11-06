<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>桌面</title>
    <style type="text/css">

        * {
            margin: 0;
            padding: 0;
        }
        li {
            list-style-type: none;
        }
        .desktop {
            overflow: hidden;
            position: fixed;
            left: 0;
            top: 0;
            height: 100%;
            width: 100%;
            background: url("static/images/background/desk.jpg");
        }
        .desktop .floater {
            position: absolute;
            right: 0;
            top: 0;
            height: 100%;
            width: 50%;
        }
        .desktop .floater .velocity-animating {
            position: absolute;
            background-color: #ffffff;
            opacity: 0;
        }
        .desktop .desk-icon {
            position: fixed;
            top: 20px;
            left: 30px;
            z-index: 1;
        }
        .desktop .desk-icon .icon-list .icon-li {
            height: 120px;
            width: 120px;
            text-align: center;
            cursor: pointer;
            margin-top: 25px;
        }
        .desktop .desk-icon .icon-list .icon-li:hover {
            background: rgba(0, 0, 0, 0.2);
        }
        .desktop .desk-icon .icon-list .icon-li img {
            height: 100px;
            width: 100px;
        }
        .desktop .desk-icon .icon-list .icon-li span {
            display: block;
            height: 20px;
            font-size: 15px;
            font-family: 楷体;
        }
        .desktop .desk-menu {
            position: fixed;
            bottom: 0;
            height: 70px;
            width: 100%;
            z-index: 1;
            text-align: center;
        }
        .desktop .desk-menu .menu-list {
            position: relative;
            margin: 0 auto;
            height: 60px;
            width: 700px;
            background: rgba(255, 255, 255, 0.54);
            top: 100%;
        }
        .desktop .desk-menu .menu-list .menu-li {
            perspective: 201px;
            float: left;
            height: 60px;
            width: 60px;
            margin: 0 5px;
        }
        .desktop .desk-menu .menu-list .menu-li img {
            height: 60px;
            width: 60px;
        }
/*        .time {
            position: fixed;
            right: 0;
            top: 0;
        }*/
        .clock {
            position: fixed;
            top: 10px;
            right: 0;
            width: 150px;
            color: #FFF;
        }
        .clock #Date {
            font-family: 'BebasNeueRegular', Arial, Helvetica, sans-serif;
            font-size: 13px;
            text-align: center;
            text-shadow: 0 0 5px #00c6ff;
        }
        .clock ul {
            width: 150px;
            margin: 0 auto;
            padding: 0px;
            list-style: none;
            text-align: center;
        }
        .clock ul li {
            display: inline;
            font-size: 20px;
            text-align: center;
            font-family: 'BebasNeueRegular', Arial, Helvetica, sans-serif;
            text-shadow: 0 0 5px #00c6ff;
        }
    </style>
</head>
<body>
<%--<a href="${ctx}/toBackStageManagement">后台管理实例</a>
<a href="${ctx}/toScriptInstance">脚本实例</a>--%>

    <div class="desktop">
        <%--时钟--%>
        <%--<canvas id="canvas" class="time" width="200px" height="200px"></canvas>--%>

        <div class="clock">

            <div id="Date">2017 十一月 3 星期五</div>

            <ul>
                <li id="hours"></li>
                <li>:</li>
                <li id="min"></li>
                <li>:</li>
                <li id="sec"></li>
            </ul>

        </div>

        <!-- 浮动气泡 -->
        <div class="floater"></div>

        <div class="desk-icon">
            <ul class="icon-list">
                <li class="icon-li">
                    <img src="${ctxStatic}/images/icon/lol13.png">
                    <span>后台管理实例</span>
                </li>
                <li class="icon-li">
                    <a href="${ctx}/im/link/login"><img src="${ctxStatic}/images/icon/lol18.png"></a>
                    <span>聊天软件</span>
                </li>
                <li class="icon-li">
                    <img src="${ctxStatic}/images/icon/lol23.png">
                    <span>脚本实例</span>
                </li>
                <li class="icon-li">
                    <img src="${ctxStatic}/images/icon/lol2.png">
                    <span>莫名其妙</span>
                </li>
            </ul>
        </div>

        <div class="desk-menu">
            <ul class="menu-list">
                <li class="menu-li">
                    <img src="${ctxStatic}/images/icon/lol1.png">
                </li>
                <li class="menu-li">
                    <img src="${ctxStatic}/images/icon/lol3.png">
                </li>
                <li class="menu-li">
                    <img src="${ctxStatic}/images/icon/lol4.png">
                </li>
                <li class="menu-li">
                    <img src="${ctxStatic}/images/icon/lol5.png">
                </li>
                <li class="menu-li">
                    <img src="${ctxStatic}/images/icon/lol6.png">
                </li>
                <li class="menu-li">
                    <img src="${ctxStatic}/images/icon/lol7.png">
                </li>
                <li class="menu-li">
                    <img src="${ctxStatic}/images/icon/lol8.png">
                </li>
                <li class="menu-li">
                    <img src="${ctxStatic}/images/icon/lol9.png">
                </li>
                <li class="menu-li">
                    <img src="${ctxStatic}/images/icon/lol10.png">
                </li>
                <li class="menu-li">
                    <img src="${ctxStatic}/images/icon/lol11.png">
                </li>
            </ul>
        </div>

    </div>


<script src="${ctx}/static/jquery.js"></script>

<script>

    $(function(){
        //屏幕下方菜单
        $(".desk-menu .menu-list .menu-li").hover(function(){
            $(this).css('width','95px');
            $(this).children().css('transform','translateZ(100px)');
            $(this).prev().children().css('transform','translateZ(70px)');
            $(this).prev().css('width','80px');
            $(this).prev().prev().children().css('transform','translateZ(50px)');
            $(this).prev().prev().css('width','70px');
            $(this).prev().prev().prev().children().css('transform','translateZ(30px)');
            $(this).next().children().css('transform','translateZ(70px)');
            $(this).next().css('width','80px');
            $(this).next().next().children().css('transform','translateZ(50px)');
            $(this).next().next().css('width','70px');
            $(this).next().next().next().children().css('transform','translateZ(30px)');
            $(".menu-list").css('width',getAllWidth(".menu-list li"));
        },function(){
            $(this).children().css('transform','');
            $(this).css('width','60px');
            $(this).prev().children().css('transform','');
            $(this).prev().css('width','60px');
            $(this).prev().prev().children().css('transform','');
            $(this).prev().prev().css('width','60px');
            $(this).prev().prev().prev().children().css('transform','');
            $(this).next().children().css('transform','');
            $(this).next().css('width','60px');
            $(this).next().next().children().css('transform','');
            $(this).next().next().css('width','60px');
            $(this).next().next().next().children().css('transform','');
            $(".menu-list").css('width','700px');
        });

        $(".desk-menu").mouseover(function(){
            $(".menu-list").animate({top:'0',bottom:'0'},'slow');
        });
        $(".desk-menu").mouseleave(function(){
            $(".menu-list").animate({top:'100%'},'slow');
            /*setTimeout(function(){
                $(".menu-list").animate({top:'100%'},'slow');
            },2000);*/
        });

    });

    var getAllWidth = function(ObjMenu){
        var obj = $(ObjMenu);
        var _w = 0;
        if(obj.length > 0){
            for(var i=0;i<obj.length;i++){
                _w += $(obj[i]).width()+10;
            }
        }
        return _w+"px";
    };
</script>
<script>

    ;(function (window, undefined) {

        var now;
        var then = Date.now();
        var interval = 800;
        var delta;
        var range = function (min, max) {
            return Math.random() * (max - min) + min;
        };

        var step = function () {
            requestAnimationFrame(step);
            now = Date.now();
            delta = now - then;

            if (delta > interval) {
                then = now - (delta % interval);
                draw();
            }
        };
        step();

        function draw() {

            var $child = $('<div class="velocity-animating"></div>'); //设定需要添加的元素
            $(".floater").append($child);

            //随机气泡大小
            var h = range(20,80);
            var height = $(".floater").height();
            var width = $(".floater").width();
            //下偏移量
            var ch = range(height/2,height);
            //右偏移量
            var cw = range(0,width);
            //运动速度
            var s = range(3000,5000);
            $child.css('height', h+'px');
            $child.css('width', h+'px');
            $child.css('border-radius', h/2+'px');
            $child.css('top', ch+'px');
            $child.css('right', cw+'px');
            $child.animate({
                opacity:'0.3'
            },400);
            $child.animate({
                top: '0',
                opacity:'0'
            },s,function(){
                $(this).remove();
            });
        };
    })(window);

</script>

<%--<script>
    //时钟
    var canvas = document.getElementById("canvas");
    var ctx = canvas.getContext("2d");

    ctx.strokeStyle = '#00ffff';
    ctx.lineWidth = 5;
    ctx.shadowBlur= 0;
    ctx.shadowColor = '#00ffff'

    function degToRad(degree){
        var factor = Math.PI/180;
        return degree*factor;
    }

    function renderTime(){
        var now = new Date();
        var today = now.toDateString();
        var time = now.toLocaleTimeString();
        var hrs = now.getHours();
        var min = now.getMinutes();
        var sec = now.getSeconds();
        var mil = now.getMilliseconds();
        var smoothsec = sec+(mil/1000);
        var smoothmin = min+(smoothsec/60);

        //Background
//        gradient = ctx.createRadialGradient(100, 100, 1, 100, 100, 50);
//        gradient.addColorStop(0, "#03303a");
//        gradient.addColorStop(1, "black");
//        ctx.fillStyle = gradient;
        ctx.fillStyle = 'rgba(0 ,0 , 0 ,1)';
        ctx.fillRect(0, 0, 200, 200);
        //Hours
        ctx.beginPath();
        ctx.arc(100,100,90, degToRad(270), degToRad((hrs*30)-90));
        ctx.stroke();
        //Minutes
        ctx.beginPath();
        ctx.arc(100,100,80, degToRad(270), degToRad((smoothmin*6)-90));
        ctx.stroke();
        //Seconds
        ctx.beginPath();
        ctx.arc(100,100,70, degToRad(270), degToRad((smoothsec*6)-90));
        ctx.stroke();
        //Date
        ctx.font = "14px Helvetica";
        ctx.fillStyle = 'rgba(00, 255, 255, 1)'
        ctx.fillText(today, 50, 100);
        //Time
        ctx.font = "14px Helvetica Bold";
        ctx.fillStyle = 'rgba(00, 255, 255, 1)';
        ctx.fillText(time, 50, 120);

    }
    setInterval(renderTime, 1000);
</script>--%>

<script type="text/javascript">
    $(document).ready(function() {

        // 创建两个变量，一个数组中的月和日的名称
        var monthNames = [ "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月" ];
        var dayNames= ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"]

        // 创建一个对象newDate（）
        var newDate = new Date();
        // 提取当前的日期从日期对象
        newDate.setDate(newDate.getDate());
        //输出的日子，日期，月和年
        $('#Date').html(newDate.getFullYear() + " " + monthNames[newDate.getMonth()] + ' ' + newDate.getDate() + '日 ' + dayNames[newDate.getDay()]);

        setInterval( function() {
            // 创建一个对象，并提取newDate（）在访问者的当前时间的秒
            var seconds = new Date().getSeconds();
            //添加前导零秒值
            $("#sec").html(( seconds < 10 ? "0" : "" ) + seconds);
        },1000);

        setInterval( function() {
            // 创建一个对象，并提取newDate（）在访问者的当前时间的分钟
            var minutes = new Date().getMinutes();
            // 添加前导零的分钟值
            $("#min").html(( minutes < 10 ? "0" : "" ) + minutes);
        },1000);

        setInterval( function() {
            // 创建一个对象，并提取newDate（）在访问者的当前时间的小时
            var hours = new Date().getHours();
            // 添加前导零的小时值
            $("#hours").html(( hours < 10 ? "0" : "" ) + hours);
        }, 1000);

    });
</script>
</body>
</html>
