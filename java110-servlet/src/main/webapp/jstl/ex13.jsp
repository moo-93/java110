<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<h1>JSTL - fmt:formatDate</h1>
<pre>
- java.util.Date 객체로 만들기
</pre>
<%
pageContext.setAttribute("today",new Date());
%>

<fmt:formatDate value="${pageScope.today}" pattern="yyyy-MM-dd"/><br>
<fmt:formatDate value="${pageScope.today}" pattern="MM/dd/yyyy"/><br>
<fmt:formatDate value="${pageScope.today}" pattern="yyyyMM-dd hh:mm:ss"/><br>

<fmt:formatDate value="${pageScope.today}" pattern="yyyy-MM-dd" var="str1"/>

<p>오늘 날짜는 '${pageScope.str1}' 입니다.</p>

</body>
</html>
