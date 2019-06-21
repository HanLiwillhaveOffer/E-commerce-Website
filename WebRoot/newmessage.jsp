<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.PreparedStatement" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.SQLException" %>
<%@ page import = "jspservlet.DB.DBConnect" %>
<%@ page import = "jspservlet.dao.ProdDAO" %>
<%@ page import = "jspservlet.dao.ShopDAO" %>
<%@ page import = "jspservlet.vo.Prod" %>
<%@ page import = "jspservlet.vo.Shop" %>
<%@ page import = "jspservlet.vo.Message" %>
<%@ page import = "jspservlet.dao.MessageDAO" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <base href="<%=basePath%>">
    <title>My JSP 'newmessage.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">  
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
   
   
   <!-- <div class="stylepadd">
   <table align="center"><tr><img width=100% height="350px" src="image/beijing.jpg"/></tr></table>
   </div>
    -->
   
   <div class="stylep2">
   <div style="font-family: cursive;font-size:xx-large; font-weight: bolder;"><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;THE MESSAGE<br/><br/><br/></div>

   <% ArrayList<Message> list=(ArrayList<Message>)session.getAttribute("list");  %>
	    	    
	<table border=2 width="80%" align="center" cellpadding="10px" style="font-family: cursive;">
     <tr><td>username</td><td>message</td></tr>
     <%  
	    for(int i =0;i<list.size();i++){
	    	Message mes = list.get(i);%>
	    	<tr>
	    	<td><%=mes.getUsername()%></td>
	    	<td><%=mes.getMessage()%></td>	    	
	    	</tr>
	    	
	    <%} %>
	    </table><br/><br/><br/><br/><br/><br/>

   
   <div class="style3">
   <ul class="ulstyle2">
   <li style="font-family: cursive; color: white;" ><a href="home.jsp"><img src="image/home.jpg"></a></li>
   <li style="font-family: cursive; color: white;" ><a href="test.jsp""><img src="image/buy.jpg"></a></li>
   <li style="font-family: cursive; color: white;" >LEGAL NOTICE<br/>Privacy ststement<br/>Copyright statement<br/>Copyright&copy;Group1</li>
   </ul>
   </div>
  </body>
</html>











