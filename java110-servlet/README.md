# 자바 서블릿 프로그래밍

## 개발 환경 구축

### 톰캣 서버 디렉토리 구조

```
bin         - 톰캣 서버 실행/종료와 관련된 파일
conf        - 톰캣 서버 설정 파일
logs        - 톰캣 실행 상황을 기록한 파일
lib         - 톰캣 서버 실행과 관련된 자바 라이브러리 파일
temp        - 톰캣 서버를 실행하는 중에 임시로 저장하는 파일
webapps     - 웹 애플리케이션을 배포
work        - JSP를 자바 소스 파일로 변환한 파일
```

### 이클립스에서 톰캣 서버 연동

- 이클립스에서 톰캣 서버를 실행하고 종료할 수 있다.
- 웹 프로젝트를 테스트하기 위해 별도의 테스트 환경을 구축한다.
- 따라서 원본 톰캣 서버의 실행 환경을 손대지 않는다.
- 원본 톰캣 서버에서 설정 파일을 복사해서 사용한다.

#### 이클립스에서 톰캣 서버 테스트 환경 구축하기
- "Servers" 뷰에서 "New > Server" 메뉴를 선택한다.
- 서버 유형 목록에서 이클립스에 등록한 톰캣 서버 버젼을 선택한다. 
- 서버 이름을 지정 후 "Finish"를 클릭한다.
- 이클립스 워크스페이스 폴더에 톰캣 서버 테스트 환경 디렉토리가 구축된다.
- 이클립스 워크스페이스에 "Servers"라는 프로젝트 폴더가 생성된다.
    - 지정한 서버 이름으로 폴더가 생성된다. ex) servlet test-config
    - 이 폴더에는 톰캣 서버 폴더에서 복사해 온 설정 파일들이 들어 있다.
    - 톰캣 서버의 원본 설정 파일을 손대지 않고, 별도로 복사해서 사용하는 것이다.
    - 개발하는 동안에는 이렇게 복사해 온 설정 파일을 사용하여 톰캣 서버를 실행한다.
- 이클립스에서 톰캣 서버 테스트 환경을 실행한다.
    - 원본 톰캣 서버의 폴더와는 별개로 테스트를 위한 별도의 폴더를 구축한다.
    - why? 각 웹 애플리케이션별로 여러 조건의 테스트를 수행하기 위함이다.
    - 톰캣 서버 테스트 환경을 실행하면 이클립스 워크스페이스  폴더에 해당 환경 디렉토리가 구축된다.

```
톰캣 서버 테스트 환경 디렉토리 구조
 (톰캣 서버 테스트 환경을 생성한 후 서버를 한 번 실행해야만 다음 폴더가 생성된다.)
[이클립스  워크스페이스 폴더] ex) c:\Users\bit-user\workspace2
.metadata\
 .plugins\
  org.eclipse.wst.server.core\
   tmp0\        - 톰캣 서버 테스트 환경(생성된 순서대로 0,1,2... 식으로 이름이 부여된다.)
    conf\       - 이클립스 "Servers/테스트 환경 폴더"에 별도로 편집된 설정파일을 복사해 온다. 
    logs\       - 테스트 환경에서 톰캣 서버를 실행하는 중에 출력된 로그 파일
    temp\       - 테스트 환경에서 톰캣 서버를 실행하는 중에 임시 작업 파일
    webapps\    - 테스트 환경에서 톰캣 서버를 실행할때는 사용 x
    work\       - 테스트 환경에서 톰캣 서버를 실행할때 JSP 변환 파일
    wtpwebapps\ - 테스트 환경에서 톰캣 서버를 실행할때 웹 애플리케이션을 배치
   tmp1\
   tmp2\
```
## 톰캣 서버 테스트 환경에 애플리케이션 배포하고 실행하기

### 애플리케이션을 배포

- 톰캣 서버 테스트 환경 메뉴에서 "Add and remove..." 선택한다.
- 왼쪽에 나열된 프로젝트 중 테스트할 프로젝트 선택하고 "add" 버튼을 클릭한다.
- 톰캣 서버 테스트 환경에서 "Publish" 또는 "Start" 메뉴 선택한다.
    - 선택한 프로젝트에서 배포할 파일들이 테스트 환경의 배포 폴더에 자동으로 복사된다.
- 주의!
    - 서버가 실행 중일 때 베포를 하면 자동으로 프로젝트 폴더에서 배포 파일이 복사된다.
    - 그러면 톰캣 서버는 배포한 웹 애플리케이션을 자동으로 로딩한다.
    - but 자동 복사가 안된다면 톰캣 서버를 멈추고 배포 프로젝트를 제거 한 후 위의 과정을 다시 수행하자
- 톰캣 서버 테스트 환경에는 톰캣 서버 원본에 있던 웹 애플리케이션이 없기 때문에
- 기본으로 웹 페이지가 없다.

### 애플리케이션 실행

톰캣 서버에 배치된 웹애플리케이션을 실행할 때 다음의 규칙에 따라 요청하라!

```
http://localhost:port/project명/경로
 ex) http://localhost:8888/java110-servlet/index.html
```

### 애플리케이션 배치명을 변경하기

- 애플리케이션의 배치 이름을 지정하지 않으면 기본이 프로젝트 명이다.
- settings.gradle 파일에서 애플리케이션 이름을 변경하자!
    -'gradle eclipse' 를 다시 실행해야 한다.

```
rootProject.name ='web01'
```

배치 폴더(tmp0/wtpwebapps)에 프로젝트를 배치할 때 프로젝트 이름으로 복사되더라도
웹 브라우저에서 요청할 때는 프로젝트명이 아니라 다음과 같이 배치 이름으로 실행해야 한다

```
http://localhost:8888/web01/index.html
```

### 웹 애플리케이션을 root로 만들기

웹 애플리케이션을 실행할 때 웹 애플리케이션 이름을 지정하기 싫다면
다음과 같이 톰켓 서버에 설정하라!

- 톰켓 서버 테스트 환경 목록에서 해당 서버 우클릭후 "open"버튼을 누른다.
- 화면에서 "Moduels" 탭을 선택한다.
- 웹 애플리케이션을 선택한 후 "Edit" 버튼을 클릭한다.
- "Path" 부분을 "/"로 변경한다.
    - 실제는 servelt.xml 파일에 배치 정보를 변경하는 것
- 톰캣 서버를 다시 시작한다.

```
웹브라우저에서 톰캣 서버에 요청할 때 웹 애플리케이션 이름을 지정하지 않아도 된다.
http:localhost:8888/index.html
```

## 웹 애플리케이션을 만드는 방법

### 웹 애플리케이션의 구성요소

- 컴포넌트
    - 서블릿, 필터, 리스너
    - 컴포넌트는 배치될 때 /WEB-INF/Classes  폴더에 배치된다.
- 웹 애플리케이션 배치 정보 파일
    - Deployment Descriptor 파일
    - 줄여서 DD 파일이라 부른다.
    - /WEB-INF/web.xml 파일이다.
    - 이 파일에 웹 컴포넌트에 대한 설정 정보를 작성한다.
- 의존 라이브러리
    - 웹 애플리케이션이 사용하는 외부 라이브러리이다.
    - 배치 폴더에서 /WEB-INF/lib 폴더에 배치된다.
- JSP 파일
    - 배치 폴더(/)에 그대로 복사된다.
- 정적 웹 리소스 파일
    - html, .css, .js, .jpeg, .png, .gif 등의 파일
    - 배치 폴더(/)에 그대로 복사된다.


### 웹 애플리케이션 서버(Web Application Server)

#### 개요

- JavaEE Spec.에 따라 만든 서버이다.
- JavaEE 스펙에 따라 작성된 애플리케이션을 실행 할 수 있다.
- 보통 WAS로 줄여서 표현

#### 구성 요소

- HTTP Server
    - HTTP 프로토콜을 기반으로 웹 브라우저의 요청을 받고 응답하는 서버
    - 실무에서 운영할 때는 웹 애플리케이션 서버에 내장된 HTTP Server를 사용 안하고
      별도의 HTTP Server(ex: Apache, nginX 등)를 구축해서 사용한다.
- Servlet Container
    - JavaEE 스펙 중에서 웹 관련 스펙을 구현한 서버이다.
    - 서블릿, 필터, 리스너, JSP를 관리하고 실행한다.
- EJB Container
    - JavaEE 스펙 중 EJB 관련 스펙을 구현한 서버이다.
    - 현재 EJB를 잘 사용하지 않는다.
    - why? POJO 기반의 Spring 프레임워크를 주로 사용하기 때문이다.
- 대표 제품
    - JavaEE의 모든 스펙을 준수하는 서버
        - Oracle의 WebLogic (유료)
        - TmaxSoft의 JEUS (유료)
        - RedHat의 JBOSS (유/무료)
        - IBM의 WebSphere (유료)
        - Oracle의 GlassFish (무료, 개발용으로 사용)
        - ASF의 Geronemo (무료)
    - JavaEE의 스펙 중에서 웹 관련 스펙만 준수하는 서버
        - 보통 미니 HTTP Server와 Servlet Container를 갖추고 있다.
        - ASF의 Tomcat (무료)
        - Caucho Technolohy의 Resin (유/무료)
        - Eclipse Jetty (무료)


#### Java EE(java Enterprise Edition) Spec.

- 기업용 애플리케이션을 제작하는데 필요한 기술을 정의한 명세이다.
- 주요 기술
    - 웹 애플리케이션 기술 : Servlet, JSP, JSF, Expreesion Language, webSocket, JSTL 등
    - 분산 컴포넌트 기술 : EJB, Message Service, Transaction, JavaMail 등
    - 웹 서비스 기술 : JAX-RS, JAX-RPC, JAXR 등
    - 관리 및 보안 기술 
- Java EE Implements(구현체)
    - Java EE 기술 명세에 따라서 동작하도록 만든 서버를 말한다.
    - Oracle에서 Java EE 명세를 제대로 구현했는지 검사하고 인증서를 발급한다.
    - 보통 WAS 라고 부르며 ,WebLogic, JBoss, JEUS 제품이 이에 해당한다.
    - Tomcat, Resin, Jetty는 Java EE 명세 중에서 웹 애플리케이션 기술만 구현한 서버이다.
- Java EE 버전
    - Java EE 는 여러 하위 기술로 구성된다.
    - Java EE 하위 기술 각각에 대해서도 버젼이 부여되고 관리된다.
    - Java EE 버젼 별로 각 하위 기술들의 버젼이 지정된다.
    - version ex:
        - java EE 8 : Servlet 4.0, JSP 2.3, JSTL 1.2, EJB 3.2 등
        - java EE 7 : Servlet 3.1, JSP 2.3, JSTL 1.2, EJB 3.2 등
        - java EE 6 : Servlet 3.0, JSP 2.2, JSTL 1.2, EJB 3.1 등
        - java EE 5 : Servlet 2.5, JSP 2.1, JSTL 1.1, EJB 3.0 등
- 웹 애플리케이션을 제작할 때 주의할 사항
    - WAS 제품의 버젼을 확인하라!
    - 그 제품이 Java EE 어떤 버젼의 구현체인지 확인하라!
    - 그 버젼에 맞춰서 Servlet/JSP 문법을 사용하라!
        

## Servlet/JSP 만들기

### 서블릿 만들기

서블릿은 클라이언트의 요청이 들어왔을 때 호출되는 자바 객체이다.

- javax.srvlet.Servlet 인터페이스에 따라 작성한다.
- @WebServlet 또는 web.xml 파일에 서블릿 정보를 등록한다.