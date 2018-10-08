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
   <h1>JSP:useBean - scope의 기본 값은 page이다.</h1>
<pre>
</pre>   

<%
request.setAttribute("name", "유관순");// ServletRequest 보관소
pageContext.setAttribute("name","안중근");// PageContext 보관소
%>

<jsp:useBean
    id="name"
    class="java.lang.String"/>

<%--
위의 태그는 다음과 같이 동작하는 자바 코드로 변환된다.
자바 코드:
java.lang.String name = 
    (java.lang.String)pageContext.getAtrribute("name");
if (name == null){
    name = new java.lang.String();
    pageContext.setAttribute("name",name);
 --%>

    
    <p>이름:<%=name%></p>

</body>
</html>
