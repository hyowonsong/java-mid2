package thisisjava.ch18.sec04.exam01;

import java.io.FileReader;
import java.io.Reader;

public class ReadExample {
    public static void main(String[] args) {
        try (Reader reader = new FileReader("src/thisisjava/ch18/sec04/exam01/write1.txt")) {

            // 1 문자씩 읽기
            while(true) {
                int data = reader.read();
                if (data == -1) {
                    break;
                }
                System.out.print((char) data);
            }

            // 문자 배열로 읽기
            char[] data = new char[10];
            while(true) {
                int num = reader.read(data);
                if (num == -1) {
                    break;
                }
                for (int i = 0; i < num; i++) {
                    System.out.print(data[i]);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
