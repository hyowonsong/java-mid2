package step12_network.ex0310.multiChat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGUIChatExam extends JFrame {
	JTextArea textArea = new JTextArea();
	JTextField textField = new JTextField();
	JScrollPane jsp = new JScrollPane(textArea); // textArea 에 스크롤이 생긴다.
	
	// 1. 멤버 필드 빼준다.
	Socket sk;
	PrintWriter pw;
	BufferedReader br;
	
	public ClientGUIChatExam() {
		super("채팅하기"); // title 넣기
		
		// Container 위에 Component 추가
		Container con = super.getContentPane();
		con.add(jsp, BorderLayout.CENTER);
		con.add(textField, BorderLayout.SOUTH);
		
		// textArea 비활성
		textArea.setFocusable(false);       // 커서 놓기 안됨
		textArea.setBackground(Color.LIGHT_GRAY);
		
		
		// 옵션 설정
		super.setSize(500, 400);
		super.setLocationRelativeTo(null);   // 정중앙 놓기
		super.setVisible(true);     // 창 보이기
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x 클릭했을 때 종료
		
		// 3. 서버 접속
		connection();
		
		// 4. textField 에 값을 입력 한 후에 enter 를 치면(event) 서버에 데이터 전송하기
		// addActionListener 는 매개변수 하나 받아야 한다.
		textField.addActionListener((e)->{
			// textField 에 있는 데이터를 읽는다.
			String inputData = textField.getText();
			// 서버에 전송한다.
			pw.println(inputData);
			// textField 를 지운다.
			textField.setText("");
		});
		
		
		// 5. 서버가 보내오는 내용을 읽을 스레드 처리
		new Thread(()->{
			try {
				String data = null;
				while ((data = br.readLine()) != null) {
					// textArea 에 추가
					textArea.append(data + "\n"); //끝에 추가
					
					// 옵션
					textArea.setCaretPosition(textArea.getText().length());
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	
	}// 생성 끝
	
	/**
	 * 2. 서버에 접속 요청 메서드
	 */
	public void connection() {
		try {
			sk = new Socket("192.168.0.40", 8000);
			
			// 여기는 대화를 주고, 받기 위해서 
			br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
			pw = new PrintWriter(sk.getOutputStream(), true);
			
			// 대화명을 입력 받을 수 있도록 하고 서버에 보내기
			String name = JOptionPane.showInputDialog(this, "대화명을 입력하세요.");
			
			// 대화명 서버에 전송
			pw.println(name);
			
			super.setTitle("[" + name +"]");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new ClientGUIChatExam();
	}
}

