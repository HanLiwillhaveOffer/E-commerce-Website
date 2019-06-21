<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ page import = "jspservlet.vo.Prod" %>
<%@ page import = "jspservlet.dao.impl.ProdDAOImpl" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>Prodshow</title>
	
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
  
 	<%
		ArrayList<Prod> list = (ArrayList<Prod>) session.getAttribute("result");
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				
		       Prod prod = list.get(i);	%>
		        <br/><br/><br/><br/><br/>
		        <table style="font-family: cursive; font-size: x-large; font-weight: bolder;" align="center" width="80%">
		        <tr>
		        <td rowspan=3 width="350px"><a href ="<%=path%>/test?prodID=<%=prod.getProdID() %>"><img src = "image/<%=prod.getImage()%>"></a></td>
		     
		        <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;prodname:<%=prod.getProdname()%></td></tr>
	            <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;price:<%=prod.getPrice()%></td></tr>
	            <tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;introduction:<%=prod.getIntro()%></td></tr>
	            </table><br/><br/><br/><br/>

		        
<%		}
		}
	%>
   </table><br/><br/><br/><br/>



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
