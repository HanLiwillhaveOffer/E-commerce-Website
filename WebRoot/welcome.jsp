<!DOCTYPE html>
<html>
  <head>
    <title>begin.jsp</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet" type="text/css" href="./begin.css">

  </head>
  
  <body>
  <%String username = (String)session.getAttribute("username"); %>
  welcome <%=username %><a href = "logout.jsp">(log out)</a>
  <br/>
  <input type = "button" name = "continue" value = "continue" onclick = "window.location.href('home.jsp')"><br/>
  <form method = "post" action = "./welcome">
  <input type = "text" name = "prodname" />
  <input type = "submit" name = "submit" value = "search">
  </form>
 <a href = "test.jsp">test</a>
  </body>
</html>
