<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>Showitem</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-ty pe" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet" type="text/css" href="./bulb.css">

  </head>
  
  <body>
  <div class="searchdiv">
  <table style="border-color: black ; border: 1px ; "  >
 <!--  <tr><td><img width=60px height= 50px src="image/logo.jpg "></td></tr> -->
  <tr>
  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
  <td>  
  <form method="post" action="./home">
  <span><input type="text" name = "prodname"></span> 
  <span style="font-family: cursive;">
  <input type="submit" value="Search"></span> 
  </form>
  </td>
  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
  <td><a href="<%=path%>/shopping"><img src="image/shopcart.jpg"></a></td>
  </tr>
  </table>
   </div>
   
   
   <div class="stylepadd">
   <table align="center"><tr><img width=100% height="350px" src="image/beijing.jpg"/></tr></table>
   </div>
       <%String username = (String)session.getAttribute("username"); %> 
<%String itemname = (String)session.getAttribute("itemname"); %> 
<%int price = (Integer)session.getAttribute("price"); %> 
<%String image = (String)session.getAttribute("image"); %> 
<%int prodID = (Integer)session.getAttribute("prodID"); %> 
   <div class="stylep2">
   <div style="font-family: cursive;font-size:xx-large; font-weight: bolder;"><br/>
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;<%=itemname %><br/><br/></div>
   <table width=80% border=0px bordercolor=black cellspan=0 height=350 align="center" style="font-family: cursive; font-weight: bolder; font-size: x-large;">
   <tr> <td rowspan=4 width=450px"><image width="300px" height="300px" src = "image/<%=image%>"/><br/></td><td>username:<%=username %><br/></td></tr>
   <tr><td>prodID:<%=prodID %><br/></td></tr>
   <tr><td>itemname:<%=itemname %><br/></td></tr>
   <tr><td>price:<%=price %><br/></td></tr>
   </table><br/><br/><br/><br/>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<form method = "post" action = "./showitem" style="font-family: cursive; font-size: x-large; font-weight: bolder;">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;






number:<input type = "text" name = "number">
<input type = "submit" name = "submit" value = "Add to my cart">
</form>
<br/><br/><br/><br/><br/>
  <!--  <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td> -->
   
  


   
   </div>
   
   <div ><img width="100%" src="image/product small .jpg" /></div>
   
   <div class="style3">
   <ul class="ulstyle2">
   <li style="font-family: cursive; color: white;" ><a href="home.jsp"><img src="image/home.jpg"></a></li>
   <li style="font-family: cursive; color: white;" ><a href="test.jsp""><img src="image/buy.jpg"></a></li>
   <li style="font-family: cursive; color: white;" >LEGAL NOTICE<br/>Privacy ststement<br/>Copyright statement<br/>Copyright&copy;Group1</li>
   </ul>
   </div>
  </body>
</html>
