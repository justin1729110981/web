<%@page language="java" contentType="text/html;charset=utf-8" %>
<%@page language="java" import="java.sql.*" %>
<!DOCTYPE html>
<html>
  <head>
    <title>跳转页面</title>
    <meta name="content-type" content="text/html; charset=UTF-8">
  </head>
  
  <body>
    
	登录成功！${currentUser}
	<a href="LogoutServlet">安全退出</a>
  <a href="main.html">进入主页面</a>
  </body>
</html>

