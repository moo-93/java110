package bitcamp.java110.cms.control;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;

// 일반 주석!
@Component
public class HelloController{
    
    @RequestMapping("hello")
    public void hello(Scanner KeyIn) {
        System.out.println("안녕하세요!!!");
    }

}
