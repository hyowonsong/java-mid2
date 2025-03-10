package thisisjava.ch19.sec03.exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 50001);
            System.out.println("[클라이언트] 연결 성공");

            String sendMessage = "나는 자바가 좋아~";
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(sendMessage);
            dos.flush();
            System.out.println("데이터 보냄 : " + sendMessage);

            // 데이터 받기
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String receiveMessage = dis.readUTF();
            System.out.println("receive message: " + receiveMessage);
            socket.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
