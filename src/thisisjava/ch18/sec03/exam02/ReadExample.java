package thisisjava.ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.InputStream;

// 바이트 배열로 읽기
public class ReadExample {
    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("src/thisisjava/ch18/sec02/exam01/write1.txt")){
            // 바이트 배열을 미리 읽기
            byte[] buffer = new byte[1024];

            while (true){
                int num = is.read(buffer);

                if (num == -1){
                    break;
                }

                for (int i=0; i<num; i++){
                    System.out.println(buffer[i]);
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
