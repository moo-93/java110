<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   trimDirectiveWhitespaces="true"
   isErrorPage="true"
 %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
   <h1>JSP:forward - RequestDispatcher.forward()</h1>
 
<pre>
- 다른 서블릿(또는 JSP)의 실행을 포함할 때 사용한다. 
    &lt;jsp:include page="서블릿 또는 JSP URL">
</pre>

<p> 연산자 ' <%request.getParameter("op"); %>'를 지원하지 않습니다.

</body>
</html>
