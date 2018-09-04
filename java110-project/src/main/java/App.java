import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner KeyIn = new Scanner(System.in);

        while(true) {
            System.out.print("이름 : ");
            String name = KeyIn.nextLine();

            System.out.print("이메일 : ");
            String email = KeyIn.nextLine();

            System.out.print("암호 : ");
            String password = KeyIn.nextLine();

            System.out.printf("%s %s %s\n",name,email,password);
            System.out.println("continue? (Y/n) ");
            String answer = KeyIn.nextLine();
            if(answer.toLowerCase().equals("n")) break;
        }
    }
}