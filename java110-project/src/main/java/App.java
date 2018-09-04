import java.util.Scanner;

public class App {
    private static String[] names = new String[100];
    private static String[] emails = new String[100];
    private static String[] passwords = new String[100];
    
    private static int index = 0;

    private static Scanner KeyIn = new Scanner(System.in);

    public static void main(String[] args) {
        inputMembers();
        printMembers();
        KeyIn.close();
    }
    
    public static void printMembers() {
        for(int i = 0; i < index; i++) {
            System.out.printf("%s %s %s\n",names[i],emails[i],passwords[i]);
        }
    }

    public static void inputMembers() {
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
    }
}