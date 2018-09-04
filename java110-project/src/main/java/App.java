import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String[] names = new String[100];
        String[] emails = new String[100];
        String[] passwords = new String[100];
        int index = 0;
        
        Scanner KeyIn = new Scanner(System.in);

        while(true) {
            System.out.print("이름 : ");
            names[index] = KeyIn.nextLine();

            System.out.print("이메일 : ");
            emails[index] = KeyIn.nextLine();

            System.out.print("암호 : ");
            passwords[index] = KeyIn.nextLine();

            index++;
            
            System.out.println("continue? (Y/n) ");
            String answer = KeyIn.nextLine();
            if(answer.toLowerCase().equals("n")) break;
        }
        for(int i = 0; i < index; i++) {
            System.out.printf("%s %s %s\n",names[i],emails[i],passwords[i]);
        }
        
        KeyIn.close();
        
    }
}