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
<h1>EL - 연산자</h1>

<h2>산술연산자</h2>
100 + 200 = ${100 + 200}<br>
100 - 200 = ${100 - 200}<br>
100 * 200 = ${100 * 200}<br>
100 div 200 = ${100 div 200}<br>
100 mod 200 = ${100 mod 200}<br>

<h2>논리연산자</h2>
true && false = ${true && false}<br>
true and false = ${true and false}<br>
true || false = ${true || false}<br>
true or false = ${true or false}<br>
not true = ${not true}<br>
!true = ${!true }<br>

<h2>관계연산자</h2>
100 == 200 = ${100 == 200}<br>
100 == 200 = ${100 eq 200}<br>
100 != 200 = ${100 != 200}<br>
100 != 200 = ${100 ne 200}<br>
100 > 200 = ${100 > 200}<br>
100 > 200 = ${100 gt 200}<br>
100 >= 200 = ${100 >= 200}<br>
100 >= 200 = ${100 ge 200}<br>
100 &lt; 200 = ${100 < 200}<br>
100 &lt; 200 = ${100 lt 200}<br>
100 &lt;= 200 = ${100 <= 200}<br>
100 &lt;= 200 = ${100 le 200}<br>

<h2>empty</h2>
<p>보관소에 해당 객체가 있는지 검사한다. 없으면 true, 있으면 false</p>
<%
pageContext.setAttribute("name", new String("hong"));
%>
name 값이 없는가? ${empty name}<br>
name2 값이 없는가? ${empty name2}<br>

<h2>조건연산자 - 조건 ? 식1 : 식2</h2>
name == "hong" : ${name == "hong" ? "넹" : "아니용" }<br>

<%
String a = "홍길동";
String b = new String("홍길동");
if(a==b){
    out.println("ㅇㅇ");
} else {
    out.println("no");
}
%>
</body>
</html>