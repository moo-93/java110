package ex01;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class MyWebApplicationInitalizer2 
    /*implements WebApplicationInitializer*/{

    public void onStartup(ServletContext servletContext) throws ServletException {
        
        
        System.out.println("MyWebApplicationInitializer2");
    }
}
