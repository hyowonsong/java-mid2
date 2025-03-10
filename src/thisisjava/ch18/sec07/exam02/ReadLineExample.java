package thisisjava.ch18.sec07.exam02;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadLineExample {
    public static void main(String[] args) {
        // Buffered 객체를 생성하고 그 안에 파일을 넣어준다.
        try (BufferedReader br = new BufferedReader(new FileReader("src/thisisjava/ch18/sec04/exam01/write1.txt"))){
            while(true){
                // Reader에 BufferedReader 를 연결하면 행 단위 문자열을 읽는 매우 편리한 readLine() 메서드를 제공해준다.
                String str = br.readLine();
                // String 이니까 -1 이 아니라 null을 체크해야 한다.
                if(str==null) break;
                System.out.println(str);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
