<%@page import="bitcamp.java110.cms.domain.Student"%>
<%@page import="java.util.List"%>
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
            <%
                List<Student> list = (List<Student>)request.getAttribute("list");
                for (Student m : list) {
            %>

            <tr>
                <td><%=m.getNo()%></td>
                <td><a
                    href='detail?no=<%=m.getNo()%>'>
                    <%=m.getName()%>
                </a></td>
                <td><%=m.getEmail() %></td>
                <td><%=m.getSchool()%></td>
                <td><%=m.isWorking()%></td>
            </tr>
            <%
}
%>
        </tbody>
    </table>
    <jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>