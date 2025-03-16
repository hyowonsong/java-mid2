package step12_network.ex0310;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLConnectionExam {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.daum.net/");
			InputStream is = url.openStream();
			
			// url 에 있는 것들 스크랩하였음
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			// 파일에 저장
			BufferedWriter bw = new BufferedWriter(new FileWriter("src/ex0310/daum.html")); 
			
			while (true) {
				String data = br.readLine(); // 한줄 읽기
				if (data == null) break;
				System.out.println(data); // 모니터에 출력
				bw.write(data);
				
				// 한 줄 씩 읽게 하기 위해 개행
				bw.newLine();
				bw.flush();
			}
			
			System.out.println("파일 저장 완료");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}																										
}

























