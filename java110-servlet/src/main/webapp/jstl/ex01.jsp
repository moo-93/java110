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
<h1>JSTL 개요</h1>
<pre>
- JSTL(JSP Standard Tag Library)?
    - JSP 확장 태그이다.
    - 기본으로 제공하지 않는다.
    - JSTL API를 구현한 외부 라이브러리를 가져와서 사용해야 한다.
- JSTL 라이브러리 가져오기
    - mvnrepository.com 에서 JSTL 검색하여 라이브러리 정보를 알아낸다.
    - bulid.gradle 파일의 dependencies {} 블럭에 추가한다.
    - 'gradle eclipse' 시행하여 이클립스 설정 파일을 갱신한다.
    - 이클립스 프로젝트를 refresh 한다.
- JSTL 라이브러리 모듈
    - Core(c) : http://java.sun.com/jsp/jstl/core
    - Xml(c) : http://java.sun.com/jsp/jstl/xml
    <%-- 국제화(Internationalization) - I18N
                        라벨명을 다른 언어로 표현할 수 있도록 프로그래밍 하는 것
                        
                        지역화(Localiztion) - L10N
                        국제화를 지원하는 프로그램이 사용할 지역 언어의 라벨명을 만드는 것
     --%>
    - I18N(fmt) : http://java.sun.com/jsp/jstl/fmt
    - Database(sql) : http://java.sun.com/jsp/jstl/sql
    - Functions(fn) : http://java.sun.com/jsp/jstl/functions
 - JSP 페이지에서 JSTL 라이브러리 모듈 사용하기
    - JSTL 모듈의 네임스페이스를 가져온다.
        &lt;@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"/>
    - JSTL 태그 사용
        &lt;접두어명:태그명 속성="값" 속성="값"/>
</pre>

<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:out value="<h2>ㅎㅇ</h2>"/>
</body>
</html>