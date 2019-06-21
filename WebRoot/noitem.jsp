<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.sql.PreparedStatement" %>
<%@ page import = "java.sql.ResultSet" %>
<%@ page import = "java.sql.SQLException" %>
<%@ page import = "jspservlet.DB.DBConnect" %>
<%@ page import = "jspservlet.dao.ProdDAO" %>
<%@ page import = "jspservlet.dao.ShopDAO" %>
<%@ page import = "jspservlet.vo.Prod" %>
<%@ page import = "jspservlet.vo.Shop" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>Noitem</title>
	
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
  <li> No item related!<li/>
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
   
   <div class="stylep2">
   <div style="font-family: cursive;font-size:xx-large; font-weight: bolder;"><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;OUR MAJIOR PRODUCT<br/><br/><br/></div>
   <table width=80% border=0 bordercolor=black cellspan=0 height=500 align="center" margin-left=10px>
   <tr >
   <td >   
     <%    String sql = "select * from prodinfo";
        PreparedStatement pstmt = null ;   
        DBConnect dbc = null;    
        dbc = new DBConnect() ;   
        pstmt = dbc.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
         %><table style="color: black;font-family: cursive; font-size: x-large;" align="center" width="80%" ><tr><td rowspan=2>
         <a href = "<%=path %>/test?prodID=<%=rs.getInt("prodID")

%>"><img width="350px" src = "image/<%=rs.getString("image")%>"></a></td>
        <td> prodname:<%=rs.getString("prodname") %><br/></td></tr>
         <tr><td>price:<%=rs.getInt("price") %><br/></td></tr></table>
         <br/><br/><br/>
         
        <%} %></td>
   <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
   
   </tr>
   <tr>
   <td>&nbsp;<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/></td>
   <td>&nbsp;<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/></td>
   <td>&nbsp;<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/></td>
   </tr>

   <tr>

   <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
  
   </tr>
   
   </table>

   
   </div>
   
   <div ><img width="100%" src="image/product small .jpg" /></div>
   
   <div class="style3">
   <ul class="ulstyle2">
   <li style="font-family: cursive; color: white;" ><a href="home.jsp"><img src="image/home.jpg"></a></li>
   <li style="font-family: cursive; color: white;" ><a href="test.jsp"><img src="image/buy.jpg"></a></li>
   <li style="font-family: cursive; color: white;" >LEGAL NOTICE<br/>Privacy ststement<br/>Copyright statement<br/>Copyright&copy;Group1</li>
   </ul>
   </div>
  </body>
</html>