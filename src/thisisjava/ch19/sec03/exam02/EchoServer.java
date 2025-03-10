package thisisjava.ch19.sec03.exam02;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    private static ServerSocket serverSocket = null;

    public static void main(String[] args) {
        // TCP  서버 시작
        startServer();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String key = scanner.nextLine();
            if (key.toLowerCase().equals("exit")) {
                break;
            }
        }
        scanner.close();
        // TCP 서버 종료
        stopServer();
    }

    public static void startServer() {
        // 작업 스레드 정의
        new Thread(() -> {
            // 람다 사용하면 안에서 run() 메서드 사용할 필요가 없음
            try {
                serverSocket = new ServerSocket(50001);
                System.out.println("서버 시작됨");

                while (true) {
                    // 연결 수락
                    Socket socket = serverSocket.accept();
                    // 연결된 클라이언트 정보 얻기
                    InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
                    System.out.println("연결 요청을 수락함");

                    // 데이터 받기
                    DataInputStream dis = new DataInputStream(socket.getInputStream());
                    String message = dis.readUTF();

                    // 데이터 보내기
                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                    dos.writeUTF(message);
                    dos.flush();
                    System.out.println(message);

                    // 연결 끊기
                    socket.close();
                    System.out.println(isa.getHostName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();     // 람다로 하면 그냥 ).start() 해주면 된다.
    }

    public static void stopServer() {
        try{
            serverSocket.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
