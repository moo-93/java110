<%@page import="bitcamp.java110.cms.domain.Teacher"%>
<%@ page
    language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"
%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

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
#photo-image {
    height: 100px;
}
</style>
</head>
<body>
    <jsp:include page="../header.jsp"></jsp:include>
    <h1>강사 상세정보(MVC)</h1>
    
    <table>
        <tbody>
            <tr>
                <th>번호</th>
                <td>${teacher.getNo()}</td>
            </tr>
            <tr>
                <th>이름</th>
                <td>${teacher.getName()}</td>
            </tr>
            <tr>
                <th>이메일</th>
                <td>${teacher.getEmail()}</td>
            </tr>
            <tr>
                <th>암호</th>
                <td>${teacher.getPassword()}</td>
            </tr>
            <tr>
                <th>전화</th>
                <td>${teacher.getTel()}</td>
            </tr>
            <tr>
                <th>시급</th>
                <td>${teacher.getPay()}</td>
            </tr>
            <tr>
                <th>과목</th>
                <td>${teacher.getSubjects()}</td>
            </tr>
            <tr>
                <th>사진</th>
                <c:choose>
                <c:when test="${not empty teacher.photo}">
                    <td><img id='photo-image' src='/upload/${teacher.photo}'></td>
                </c:when>
                <c:otherwise>
                    <td><img id='photo-image' src='/img/anonymous.png'></td>
                </c:otherwise>
                </c:choose>
            </tr>
            
        </tbody>
    </table>
    <button type='button' onclick='remove()'>삭제</button>
    <script>
                    function remove() {
                        location.href = 'delete?no=${teacher.no}'
                    }
    </script>
    <jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>
