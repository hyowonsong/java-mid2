package thisisjava.ch18.sec03.exam01;

import java.io.FileInputStream;
import java.io.InputStream;

// 3. 바이트 읽기
public class ReadExample {
    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("src/thisisjava/ch18/sec02/exam01/write1.txt")){

            // while문 잘 생각
            while (true){
                int data = is.read();

                if (data == -1){
                    break;
                }
                System.out.println(data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
