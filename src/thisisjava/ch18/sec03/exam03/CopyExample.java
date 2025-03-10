package thisisjava.ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
    public static void main(String[] args) {
        // try 문에 여러 문장 쓸때, 오류 조심
        try(InputStream is = new FileInputStream("src/thisisjava/ch18/sec02/exam01/write1.txt");
            OutputStream os = new FileOutputStream("src/thisisjava/ch18/sec02/exam01/write2.txt")) {

            byte[] data = new byte[1024];
            while (true) {
                int num = is.read(data);
                if (num == -1) {
                    break;
                }
                os.write(data,0,num);
            }
            os.flush();

            System.out.println("복사가 잘 되었습니다.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
