package thisisjava.ch18.sec09;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamExample {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("src/thisisjava/ch18/sec09/printStream.txt");
            PrintStream ps = new PrintStream(fos)) {

            ps.print("마치 ");
            ps.println("프린터가 출력되는 것처럼");
            ps.println("데이터가 출력합니다.");
            ps.flush();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
