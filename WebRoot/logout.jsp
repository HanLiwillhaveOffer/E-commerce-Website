<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<title>Logout</title>
<link href="css/login new.css" rel='stylesheet' type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="App Sign in Form,Login Forms,Sign up Forms,Registration Forms,News latter Forms,Elements"./>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
</script>
<!--webfonts-->
<link href='login new.css' rel='stylesheet' type='text/css'>
<!--//webfonts-->
</head>
<body>
<h1 style="font-family: cursive;">Logout</h1>
<div class="app-cam">
<div class="cam"><img src="image/cam.png" class="img-responsive" alt="" /></div>
<form method = "post" action = "./logout" style="font-size: xx-large; color: white">
 Are you sure you want log out?</br>
<div class="submit"><input type="submit" name = "submit" value="YES" style="font-family: cursive;"></div>
<a href = "home.jsp" style="font-size: xx-large;" >NO!!!</a>
<div class="clear"></div>
<div class="buttons">
</form>



	
<div class="copy-right">
<p>Copyright &copy; 2015.Group 1 name All rights reserved.</p>
</div>
</body>
</html>
