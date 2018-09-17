package bitcamp.java110.cms.client;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClinetApp {

    //여러 속성의 값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용한다.
    static Scanner KeyIn = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        while(true) {
            // 사용자로부터 명령어를 입력 받는다.
            String requestLine = prompt();
            if (requestLine.equals("EXIT")){
                System.out.println("goodbye");
                break;
            }
            try (
                    Socket socket = new Socket("192.168.0.8", 8888);
                    PrintStream out = new PrintStream(
                            new BufferedOutputStream(
                                    socket.getOutputStream()));
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));
                    ) {
                // 입력 받은 명령어를 서버에 보낸다.
                out.println(requestLine); out.flush();
                
                // 서버가 응답한 내용을 받아서 출력한다.
                while(true) {
                    String responseLine = in.readLine();
                    if(responseLine.length() == 0)
                        break;
                    System.out.println(responseLine);
                } 
            } catch (Exception e) {
                e.printStackTrace();
            }
        } //while
        KeyIn.close();
    } //main


    private static String prompt() {
        System.out.print("입력 > ");
        return KeyIn.nextLine();

    }
}