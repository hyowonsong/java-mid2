package thisisjava.ch18.sec02.exam01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// 1. 바이트 출력
public class WriteExample {
    public static void main(String[] args) {
        // 파일 저장
        try (OutputStream os = new FileOutputStream("src/thisisjava/ch18/sec02/exam01/write1.txt")) {
            byte a = 10;
            byte b = 20;
            byte c = 30;

            os.write(a);
            os.write(b);
            os.write(c);

            os.flush();
        } catch (IOException e){
            e.getMessage();
        }
    }
}
