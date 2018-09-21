/*
 * 클라이언트가 보낸 데이터 읽기 - POST 요청으로 보낸 데이터 한글이 깨지는거 문제 해결
 */
package bitcamp.java110.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex04/servlet05")
public class Servlet05 extends GenericServlet{

    private static final long serialVersionUID = 1L;

    @Override
    public void service(
            ServletRequest req,
            ServletResponse res)
                    throws ServletException, IOException {

        // => http://localhost:8888/ex04/post2.html
        
        // => 클라이언트가 보낸 데이터가 어떤 문자표로 인코딩 되었는지 알려준다.
        //    만약 알려주지 않으면, ISO-8859-1로 인코딩되었다고 간주한다.
        //    즉 클라이언트가 보낸 데이터가 모두 영문이나 숫자라고 간주하고,
        //    각 바이트 앞에 00 1바이트를 붙여 Unicode로 변환한다.
        //    그래서 한글의 경우 잘못 변환되어 깨지는 것이다.
        // => 주의! getParameter()를 단 한 번이라도 호출하기 전에
        //    먼저 설정해야 한다. 그 이후에 설정한다면 적용되지 않는다.
        // => 초보 개발자가 많이 놓치는 예:
        //    서블릿 앞에 필터를 꼽았고 그 필터에서 getParameter()를 호출한 경우
        //    이미 getParameter()를 호출했기 때문에
        //    서블릿에서 setCharacterEncoding()을 호출해봐야 소용 없다
        //    중요함중요씹중요개중요제발중요제발염!
        
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("name");
        int age = Integer.parseInt(
                req.getParameter("age"));
        boolean working = Boolean.parseBoolean(
                req.getParameter("working"));

        res.setContentType("text/plain; charset=UTF-8");

        PrintWriter out = res.getWriter();
        out.printf("name=%s\n", name);
        out.printf("age=%d\n", age);
        out.printf("working=%b\n", working);

    }    
}