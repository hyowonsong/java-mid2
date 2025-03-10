package thisisjava.ch18.sec02.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// 2. 바이트 배열 출력
public class WriteExample {
    public static void main(String[] args) {
        try(OutputStream os = new FileOutputStream("src/thisisjava/ch18/sec02/exam02/write.txt")) {
            byte[] b = {1,2,3};

            os.write(b);
            os.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
