<%@page import="bitcamp.java110.cms.domain.Student"%>
<%@ page
    language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>매니저 관리</title>
<link rel='stylesheet' href='../css/common.css'>
<style>
table {
    border-collapse: collapse;
}

th, td {
    border: 1px solid red;
}
</style>
</head>
<body>
    <jsp:include page="../header.jsp"></jsp:include>
    <h1>학생 목록(MVC)</h1>
    <span><a href='add'>추가</a></span>
    <table>
        <thead>
            <tr>
                <th>번호</th>
                <th>이름</th>
                <th>이메일</th>
                <th>최종학력</th>
                <th>재직여부</th>
            </tr>
        </thead>
        <tbody>
        
        <jsp:useBean
            scope="request"
            id="list"
            class="java.util.ArrayList"
            type="java.util.List<Student>"
            />
        
            <%
                for (Student s : list) {
                    pageContext.setAttribute("s",s);
            %>

            <tr>
                <td>${s.getNo()}</td>
                <td><a
                    href='detail?no=${s.getNo()}'>
                    ${s.getName()}
                </a></td>
                <td>${s.getEmail()}</td>
                <td>${s.getSchool()}</td>
                <td>${s.isWorking()}</td>
            </tr>
            <%
}
%>
        </tbody>
    </table>
    <jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
