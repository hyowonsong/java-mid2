package step12_network.ex0310.multiChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*
 * 클라이언트와 멀티채팅을 위한 Server
 */
public class ServerGUIChatExam {
	// 외부로 소켓을 빼놓는다.
	Socket sk; 
	// IP도 얻어오기 
	String userIp;
	// 4. 리스트 저장
	List<ClientSocketThread> list = new ArrayList<>();
	
	public ServerGUIChatExam() {
		// 서버 소켓을 여러개 만들 수 있다.
		try (ServerSocket server = new ServerSocket(8000)){
			while (true) {
				System.out.println("접속 대기 중입니다.");
				// 1. 클라이언트 접속 대기 받기
				sk = server.accept();
				// InetAddress 는 문자열은 아니기 때문에 toString() 해줘야
				userIp = sk.getInetAddress().toString();
				System.out.println(userIp + "님 접속 되었습니다.");
				
				// 3. Thread 생성해서 list 에 저장한다.
				ClientSocketThread th = new ClientSocketThread();
				th.start();
				
				list.add(th);
				
				System.out.println("현재 접속 인원 : " + list.size() + "명\n");		
			}		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // 생성자 끝
	//////////////////////////////////////////////////////////////////////
	/**
	 * 클라이언트 Socket 을 스레드로 만들어서 클라이언트가 보내오는 내용을 읽어
	 * 접속된 모든 클라이언트에게 데이터를 전송하는 스레드 (Inner 클래스)
	 * 이너 클래스로 만들어서 Thread 를 굳이 넘겨줄 필요 없이 멤버필드 사용 가능
	 */
	
	class ClientSocketThread extends Thread {
		// 2. 리스트에서 읽어 오려고 멤버변수로 빼 놓음 -> 이거 멤버변수로 안빼면?
		BufferedReader br;
		PrintWriter pw;
		String nickName;
		
		public ClientSocketThread() {
			try {
				// 읽기
				br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
				// 쓰기
				pw = new PrintWriter(sk.getOutputStream(), true);
			} catch (Exception e) {
				System.out.println("생성자 catch.....");
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {

			try {
				// 5. 대화명 받기 준비
				nickName = br.readLine();
				
				// 접속된 모든 client 에게 "~님 입장" 메시지 전송 -> 이건 메소드로 빼서 만들기
				/*(ClientSocketThread th : list){
					th.pw.println(nickName);
				}*/
				
				// 7. 메시지 전송
				sendMessage("["+nickName +"] 님 입장하셨습니다.");
				
				
				// 8. 다른 대화를 할 수 있도록 while 문 추가
				while (true) {
					String inputData = br.readLine(); // 접속된 현재 스레드 user 의 br 에서 읽어들일 데이터를 있는다.
					if (inputData == null) break;
					// 읽은 데이터를 모든 user 에게 전송
					sendMessage("["+nickName+"]" + inputData);
				}
			} catch (Exception e) {
				// 9. 현재 스레드에서 예외가 발생했다. 즉, sk 이 끊긴 경우
				
				// list 에 현재 스레드(자기자신)를 제거한다.
				list.remove(this);
				// 모든 user 에게 알린다.
				sendMessage("["+nickName+"]님이 퇴장하셨습니다.");
				
				System.out.println("["+nickName+"]님이 퇴장하셨습니다. | 현재 인원 =" + list.size() + "명" );
			}
		}	
	} // 이너 클래스 끝
	
	/**
	 * 6. list 에 있는 thread 를 조회해서 pw 를 이용해 모든 user 에게 데이터를 전송하는 메서드
	 */
	public void sendMessage(String message) {
		for (ClientSocketThread th : list) {
			th.pw.println(message); // 클라이언트에게 전송한다.
		}
	}
	
	public static void main(String[] args) {
		new ServerGUIChatExam();
	}
}


















