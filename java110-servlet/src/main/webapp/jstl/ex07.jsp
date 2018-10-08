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
<h1>JSTL - c:foreach</h1>
<pre>
- 반복문을 만든다.
</pre>

<h2>배열</h2>
<%
pageContext.setAttribute("names", new String[]{"hong", "lim", "you"});
%>
<ul>
<c:forEach items="${pageScope.names}" var="n">
    <li>${n}</li>
</c:forEach>
</ul>

<h2>Collection</h2>
<%
List<String> names2 = new ArrayList<>();
names2.add("hong");
names2.add("lim");
names2.add("you");
pageContext.setAttribute("names2", names2);
%>
<ul>
<c:forEach items="${pageScope.names2}" var="n">
    <li>${n}</li>
</c:forEach>
</ul>

<h2>Map 객체</h2>
<%
Map<String, Object> names3 = new HashMap<>();
names3.put("s01","hong");
names3.put("s02","lim");
names3.put("s03","you");

pageContext.setAttribute("names3", names3);
%>

<ul>
<%-- Map 객체에 대해 반복문을 돌리면 var로 저장하는 것은
     key와 values를 갖고 있는 Entry 객체이다. --%>
<c:forEach items="${pageScope.names3}" var="n">
    <li>${n.key}: ${n.value}</li>
    <li>${n}</li>
</c:forEach>
</ul>

<h2>CSV(comma separated value) 문자열</h2>
<%
pageContext.setAttribute("names4","hong,lim,you,kim");
%>
<ul>
<c:forEach items="${pageScope.names4}" var="n">
    <li>${n}</li>
</c:forEach>
</ul>
</body>
</html>

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