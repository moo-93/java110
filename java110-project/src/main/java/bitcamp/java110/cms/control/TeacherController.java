package bitcamp.java110.cms.control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.domain.Teacher;

@Component("teacher")
public class TeacherController {

    private List<Teacher> teachers = new ArrayList<>();
    
    @RequestMapping
    public void teacher(Scanner KeyIn) {
        while(true) {
            System.out.println("[list] or [add] or [delete]"
                    + " or [detail] or [quit] ");
            System.out.print("강사 관리 > ");

            String command = KeyIn.nextLine();

            if (command.equals("list")) {    
                printTeachers();
            } else if(command.equals("add")) {
                inputTeachers(KeyIn);
            }else if(command.equals("delete")) {
                deleteTeacher(KeyIn);
            } else if(command.equals("detail")) {
                detailTeacher(KeyIn);
            } else if(command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }
    
    private void printTeachers() {
        for(int i = 0; i < teachers.size(); i++) {
            Teacher t = teachers.get(i);
            System.out.printf("%d : %s, %s, %s, %s, %b, %s\n"
                    ,i
                    ,t.getName()
                    ,t.getEmail()
                    ,t.getPassword()
                    ,t.getTel()
                    ,t.getPay()
                    ,t.getSubjects());
        }
    }
    
    private void inputTeachers(Scanner KeyIn) {
        while(true) {
            Teacher t = new Teacher();

            System.out.print("이름 : ");
            t.setName(KeyIn.nextLine());

            System.out.print("이메일 : ");
            t.setEmail(KeyIn.nextLine());

            System.out.print("암호 : ");
            t.setPassword(KeyIn.nextLine());
            
            System.out.print("전화번호  : ");
            t.setTel(KeyIn.nextLine());
            
            System.out.print("시급 : ");
            t.setPay(Integer.parseInt(KeyIn.nextLine()));
            
            System.out.print("강의과목 : ");
            t.setSubjects(KeyIn.nextLine());
            
            teachers.add(t);

            System.out.print("continue? (Y/n) ");
            String answer = KeyIn.nextLine();
            if(answer.toLowerCase().equals("n")) break;
        }
    }
    
  

    private void deleteTeacher(Scanner KeyIn) {
        System.out.print("삭제할 번호 : ");
        int num = Integer.parseInt(KeyIn.nextLine());
        
        if(num < 0 || num >= teachers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        teachers.remove(num);
        System.out.println("삭제 완료");
    }

    private void detailTeacher(Scanner KeyIn) {
        System.out.print("조회할 번호 : ");
        int num = Integer.parseInt(KeyIn.nextLine());

        if(num < 0 || num >= teachers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        Teacher t = teachers.get(num);
        System.out.printf("이름 : %s\n", t.getName());
        System.out.printf("이메일 : %s\n", t.getEmail());
        System.out.printf("암호 : %s\n", t.getPassword());
        System.out.printf("전화 : %s\n", t.getTel());
        System.out.printf("시급 : %s\n", t.getPay());
        System.out.printf("강의과목 : %s\n", t.getSubjects());
    }

}
