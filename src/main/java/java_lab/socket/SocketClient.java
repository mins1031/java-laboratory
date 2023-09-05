package java_lab.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {
    private Socket clientSocket; // 클라이언트 소켓
    private BufferedReader br; // 클라이언트로부터 전달받은 메시지를 읽어드릴 버퍼 메모리
    private PrintWriter pw; // 클라이언트로 메시지를 보냄
    private Scanner sc; // 데이터 입력

    public static void main(String[] args) {
        new SocketClient();
    }

    public SocketClient() {
        init();
    }

    public void init() {
        try {
            clientSocket = new Socket("localhost", 8981);
            System.out.println("Server Connect");

            br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));// 서버로 부터 데이터를 받아올 준비
            pw = new PrintWriter(clientSocket.getOutputStream());// 서버로 데이터를 보낼 준비

            sc = new Scanner(System.in);//입력한 데이터를 읽을 준비

            while(true) {
                System.out.print("to Server: ");
                String next = sc.nextLine();
                if (next.equals("exit")) {
                    break;
                }
                pw.println(next);//보낼 내용을 읽어와서 서버로 보낸다
                pw.flush();//프린터 라이터 메모리를 초기화 시켜서 내부에 있던 데이터를 서버로 전송한다

                System.out.println("from Server: " + br.readLine()); //서버에서 받은 데이터를 표기한다.
            }
            System.out.println("Exit@!");
            clientSocket.close();//연결 종료하면 소켓을 닫는다.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
