<%@page import="bitcamp.java110.cms.domain.Manager"%>
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
<link
    rel='stylesheet'
    href='../css/common.css'
>
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
    <h1>매니저 상세정보(MVC)</h1>

    <table>
        <tbody>
            <tr>
                <th>번호</th>
                <td>${manager.no}</td>
            </tr>
            <tr>
                <th>이름</th>
                <td>${manager.name}</td>
            </tr>
            <tr>
                <th>이메일</th>
                <td>${manager.email}</td>
            </tr>
            <tr>
                <th>암호</th>
                <td>${manager.password}</td>
            </tr>
            <tr>
                <th>전화</th>
                <td>${manager.tel}</td>
            </tr>
            <tr>
                <th>직위</th>
                <td>${manager.position}</td>
            </tr>



        </tbody>
    </table>
    <button
        type='button'
        onclick='remove()'
    >삭제</button>
    <script>
                    function remove() {
                        location.href = ${manager.no}
                    }
    </script>
    <jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
