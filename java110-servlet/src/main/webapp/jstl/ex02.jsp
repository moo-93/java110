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
<h1>JSTL - c:out</h1>
<pre>
- 출력문을 만드는 태그이다.
  &lt;c:out value="출력될 값" default="기본 값"/>
  &lt;c:out value="출력될 값">기본값&lt;c:out>
</pre>

<c:out value="lim"/><br>
<c:out value="${null}" default="hong"/><br>
<c:out value="${'lim'}" default="hong"/><br>
<c:out value="${null}">hong</c:out><br>
</body>
</html>