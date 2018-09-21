/*
 * 클라이언트가 보낸 데이터 읽기 - POST 요청으로 보낸 데이터
 */
package bitcamp.java110.ex04;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/ex04/servlet03")
public class Servlet03 extends GenericServlet{

    private static final long serialVersionUID = 1L;

    @Override
    public void service(
            ServletRequest req,
            ServletResponse res)
                    throws ServletException, IOException {
        // 멀티파트 형식으로 업로드 된 데이터를 getParameter()로 값을 꺼낼 수 없다.
        // => 별도의 처리 작업을 해야 한다.

        /*String name = req.getParameter("name");
        int age = Integer.parseInt(
                req.getParameter("age"));
        boolean working = Boolean.parseBoolean(
                req.getParameter("working"));
        String file1 = req.getParameter("file1");
        String file2 = req.getParameter("file2");*/

        // 1) 멀티 파트 데이터를 분석하여 객체로 만드는 공장을 준비한다.
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // 2) 클라이언트 요청을 처리할 객체를 준비하고 공장과 연겷한다.
        ServletFileUpload upload = new ServletFileUpload(factory);

        // 3) 클라이언트 요청을 처리한다.
        //     => ServletFileUpload는 ServletRequest 객체를 통해 데이터를 읽는다.
        //     => 각 파트는 DiskFileItemFactory를 통해 FileItem 객체로 만든다.
        HashMap<String,String> parts = new HashMap<>(); // 파라미터 명, 파라미터 값
        try {
            List<FileItem> items = upload.parseRequest((HttpServletRequest)req);

            for (FileItem item : items) {
                if(item.isFormField()) { // 일반 데이터
                    parts.put(item.getFieldName(),item.getString("UTF-8"));
                } else { // 파일
                    String filename = UUID.randomUUID().toString(); // UUID << 중복되지 않은 문자열을 리턴

                    parts.put(item.getFieldName(),filename);
                    
                    String path = this.getServletContext()
                            .getRealPath("/upload/" + filename);
                    
                    item.write(new File(path));
                }
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        res.setContentType("text/plain; charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.printf("name=%s\n", parts.get("name"));
        out.printf("age=%d\n", Integer.parseInt(parts.get("age")));
        out.printf("working=%b\n", Boolean.parseBoolean(parts.get("working")));
        out.printf("file1=%s\n", parts.get("file1"));
        out.printf("file2=%s\n", parts.get("file2"));

    }    
}