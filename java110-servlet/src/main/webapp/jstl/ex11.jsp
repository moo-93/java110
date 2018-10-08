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
<h1>JSTL - c:redirect</h1>
<pre>
- redirect 응답하기
</pre>

<c:if test="${param.search == 'naver'}">
    <c:redirect url="http://www.naver.com"></c:redirect>
</c:if>

<c:if test="${param.search == 'daum'}">
    <c:redirect url="http://www.daum.net"></c:redirect>
</c:if>

<p>search 라는 이름으로 검색 엔진을 지정하세요!</p>
<p>유효한 엔진은 naver, daum 입니다.</p>

</body>
</html>
