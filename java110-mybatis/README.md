# Mybatis persistence framework

## 라이브러리 준비
- mvnrepository.com 에서 'mybats'로 검색한다.
- bulid.gradle에 mybatis 의존 라이브러리 객체를 추가한다.
- console에서 'gradle eclipse' 실행한다.
- eclipse에서 project를 refresh한다.

## mybatis 적용
- SqlSessionFactory 객체 준비
    - 'Getting Started' 문서에서 코드 발췌하여 자바 소스
    파일에 둔다.
- Mybatis 설정 파일 준비
    - 'Getting Started' 문서에서 코드를 발췌한다.
    - mybatis-config.xml(이름 변경 가능) 설정 파일에 붙여 넣는다.
- Sql mapper 파일 준비
    - 'Getting Started' 문서를 찹조하여 SQL 맵퍼 파일을 만든다.
    - MemberDao.xml 파일 생성
- Dao에 적용