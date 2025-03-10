package thisisjava.ch18.example.number9;

import java.io.*;
import java.util.Scanner;

public class FileReader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("원본 파일 경로: ");
        String orgPath = sc.nextLine();

        System.out.print("복사 파일 경로: ");
        String dstPath = sc.nextLine();

        File orgFile = new File(orgPath);
        if (!orgFile.exists()) {
            System.out.println("원본 파일이 존재하지 않습니다.");
            System.exit(0);
        }

        File dstFile = new File(dstPath);
        File parentFile = dstFile.getParentFile();
        if (!parentFile.exists()) { // 수정: parentFile을 직접 사용
            parentFile.mkdirs();
        }

        // try-with-resources 적용 (자동 close)
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(orgPath));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dstPath))) {

            bis.transferTo(bos);
            System.out.println("복사가 성공되었습니다.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
