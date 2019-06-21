<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> 
<html xmlns="http://www.w3.org/1999/xhtml">
<html>
  <head>
    <title>Home</title>
	
  <!--  <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
   -->   
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet" type="text/css" href="./bulb.css">

<script type="text/javascript" src="babyzone.js"></script>
<style type="text/css">
#banner {position:relative; width:1366px; height:500px; border:1px solid #666; overflow:hidden;}
#banner_list img {border:0px;}
#banner_bg {position:absolute; bottom:0;background-color:#000;height:30px;filter: Alpha(Opacity=30);opacity:0.3;z-index:1000;cursor:pointer; width:500px; }
#banner_info{position:absolute; bottom:0; left:5px; line-height:30px;color:#fff;z-index:1001}
#banner_text {position:absolute;width:120px;z-index:1002; right:3px; bottom:3px;}
#banner ul {position:absolute;list-style-type:none;filter: Alpha(Opacity=75);opacity:0.75; border:1px solid #fff;z-index:1002;margin:0; padding:0; bottom:3px; right:5px;}
#banner ul li { padding:0px 8px;float:left;display:block;color:#FFF;border:#fff 1px solid;background-color:#6f4f67;cursor:pointer}
#banner ul li.on{ background-color:#900}
#banner_list a{position:absolute;} <!-- 让四张图片都可以重叠在一起-->
</style>
<script type="text/javascript" language="javascript">
window.onload=function(){
	//
	babyzone.scroll(4,"banner_list","list","banner_info");
}
</script>

  </head>
  
  <body>
   <div class="style1">
  <ul class="ulstyle" style="font-family: cursive;">
  <div class="wodeshen"><%String username = (String)session.getAttribute("username"); 
  if(username!=null){%>
   welcome <%=username %><a href = "logout.jsp">(log out)</a>
   <%} %>
   </div>
   <li><a href="login.jsp">LOGIN/OUT</a></li>
   <li><a href="test.jsp">PRODUCT</a></li>
   <li><a href="<%=path %>/shopping">SHOPCART</a></li>
   <li><a href="aboutus.html">ABOUTUS</a></li>
   <li><a href="<%=path%>/message">BOARD</a></li>
 <!--   <li><a href="#"><img src="image/1.jpg" width=120px height=50px/></a></li> -->
   </ul> 
   </div>
   
   
  <!--  <div class="style2"> -->
   
   <div id="banner">	
	<div id="banner_bg"></div>  <!--标题背景-->
	<a href="#" id="banner_info"></a> <!--标题-->
    <ul id="list"></ul>
   <div id="banner_list">
        <a href="#" target="_blank"><img src="imgs/p1.jpg"  /></a>
        <a href="#" target="_blank"><img src="imgs/p5.jpg"  /></a>
        <a href="#" target="_blank"><img src="imgs/p3.jpg" /></a>
        <a href="#" target="_blank"><img src="imgs/p4.jpg" /></a>
	</div>
</div>

<!-- </div> -->



  <div class="style3">
   
   <ul class="ulstyle2">
   <li style="font-family: cursive; color: white;" padding-top: "10px" ><a href="contact.html"><img src="image/contact.jpg"></a><br/></li>
   <li style="font-family: cursive; color: white;" ><a href="test.jsp"><img src="image/buy.jpg"></a></li>
   <li style="font-family: cursive; color: white;" >LEGAL NOTICE<br/>Privacy ststement<br/>Copyright statement<br/>Copyright&copy;Group1</li>
   </ul>
   </div>
  </body>
</html>
