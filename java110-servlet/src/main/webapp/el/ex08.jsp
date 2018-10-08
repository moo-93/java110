<%@page import="bitcamp.java110.Member"%>
<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<h1>EL - 객체에서 값 꺼내기</h1>
<%
Member member = new Member();
member.setNo(100);
member.setName("hong");
member.setEmail("hong@test.com");
member.setTel("1111-1231");

pageContext.setAttribute("member",member);
%>
${member["no"]}<br>
${member['no']}<br>
${member.no}<br>
${member.getNo()}<br>

</body>
</html>