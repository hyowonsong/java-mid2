package thisisjava.ch18.sec04.exam01;

import java.io.FileWriter;
import java.io.Writer;

public class WriteExample {
    public static void main(String[] args) {
        try (Writer writer = new FileWriter("src/thisisjava/ch18/sec04/exam01/write1.txt")){
            // 1 문자씩 출력
            char a = 'A';
            writer.write(a);
            char b = 'B';
            writer.write(b);

            // char 배열 출력
            char[] arr = {'C','D','E','F','G','H'};
            writer.write(arr);

            // 문자열 출력
            writer.write("FGH");

            // 버퍼에 잔류하고 있는 문자들을 출력하고, 버퍼를 비움
            writer.flush();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
