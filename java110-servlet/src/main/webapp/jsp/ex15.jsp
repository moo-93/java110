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
- 포워딩 되는 조건은 버퍼에 내용이 남아있을때 포워딩 가능!
</pre>

<% 
int a  = Integer.parseInt(request.getParameter("a"));
int b  = Integer.parseInt(request.getParameter("b"));
String op = request.getParameter("op");

int result = 0;

switch(op){
case "+" : result = a + b ; break;
case "-" : result = a - b ; break;
default :%>
    <jsp:forward page="ex15_error.jsp"></jsp:forward>

<%
return;
}
%>
<p><%=a%> <%=op%> <%=b%> = <%=result%></p>

</body>
</html>
