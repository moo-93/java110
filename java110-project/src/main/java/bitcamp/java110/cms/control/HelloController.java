package bitcamp.java110.cms.control;

import java.util.Scanner;

import bitcamp.java110.cms.annotation.Component;

// 일반 주석!
@Component("4")
public class HelloController implements Controller{

    public String name ="4";
    @Override
    public void service(Scanner KeyIn) {
        System.out.println("안녕하세요!!!");
    }

}
