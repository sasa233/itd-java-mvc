<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	
  </head>
  
  <body>
  	
  	获取当前路径<%=request.getContextPath()%>
    
    <form action="${pageContext.request.contextPath}/productController/save.mvc" method="post">
    	 <!-- 只要name属性与controller对象的属性相同,则自动注入 -->
      	商品名称:<input type="text" name="name" value="test01" /><br />
      	商品价格:<input type="text" name="price" value="3.14" /><br />
    	商品备注:<input type="text" name="remark" value="我是备注!" /><br />
      	<button type="submit">提交</button>
    </form>
    
  </body>
</html>
