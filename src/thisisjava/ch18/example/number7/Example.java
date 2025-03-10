package thisisjava.ch18.example.number7;

import java.io.BufferedReader;
import java.io.FileReader;

public class Example {
    public static void main(String[] args) throws Exception {
        String filePath = "src/thisisjava/ch18/example/number7/Example01.java";

        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);

        while (true){
            String line = br.readLine();

            if (line == null){
                break;
            }
            System.out.println(line);
        }
    }
}
