<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>HRM日常考勤系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    
  </head>
  
  <body>
    <center><h1><a href="doTest.do">欢迎使用日常考勤系统</a></h1></center>
  </body>
</html>
