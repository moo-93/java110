<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<h1>JSTL - c:forTokens</h1>
<pre>
</pre>

<h2>CSV(comma separated value) 문자열</h2>
<%
pageContext.setAttribute("names4","hong,lim,you,kim");
%>
<ul>
<c:forTokens items="${pageScope.names4}" var="n" delims=",">
    <li>${n}</li>
</c:forTokens>
</ul>

<h2>Query String 문자열</h2>
<%
pageContext.setAttribute("qs","name=홍길동&age=20&tel=1111-2222");
%>
<ul>
<c:forTokens items="${pageScope.qs}" var="n" delims="&">
    <li>${n}</li>
</c:forTokens>
</ul>
</body>
</html>
