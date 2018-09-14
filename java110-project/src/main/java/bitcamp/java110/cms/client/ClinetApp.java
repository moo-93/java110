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

        try (
                // 서버에 연결하기
                Socket socket = new Socket("localhost", 8888);

                // 서버에 데이터를 보내고 읽을 도구를 준비하기
                PrintStream out = new PrintStream(
                        new BufferedOutputStream(
                                socket.getOutputStream()));

                BufferedReader in = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()));
                ) {
            // 클라이언트에서 보내면
            // 서버에서 읽었을때  readLine()
            // 다음 라인으로 넘어간다.
            out.println("HELLO");
            out.flush();
            System.out.println(in.readLine());
            
            while(true) {
                String requestLine = prompt();
                out.println(requestLine); out.flush();
                while(true) {
                    String responseLine = in.readLine();
                    if(responseLine.length() ==0)
                        break;
                    System.out.println(responseLine);
                }

                if (requestLine.equals("EXIT")){
                    System.out.println("goodbye");
                    break;
                }

            }
        }
        KeyIn.close();
    }


    private static String prompt() {
        System.out.print("입력 > ");
        return KeyIn.nextLine();

    }
}