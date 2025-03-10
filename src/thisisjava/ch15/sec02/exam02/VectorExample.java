package thisisjava.ch15.sec02.exam02;

import thisisjava.ch15.sec02.exam01.Board;
import java.util.List;
import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        List<Board> list = new Vector<>();

        // 작업 스레드 객체 생성
        Thread threadA = new Thread(){
            @Override
            public void run() {
                // 객체 1000개 추가
                for (int i = 1001; i<= 2000; i++){
                    list.add(new Board("제목" + i, "내용" +i, "글쓴이" + i));
                }
            }
        };

        // 작업 스레드 객체 생성
        Thread threadB = new Thread(){
            @Override
            public void run() {
                // 객체 1000개 추가
                for (int i = 1001; i<= 2000; i++){
                    list.add(new Board("제목" + i, "내용" +i, "글쓴이" + i));
                }
            }
        };

        threadA.start();
        threadB.start();

        // 작업 쓰레드들이 모두 종료될 때까지 메인 스레드를 기다리게 함
        try{
            threadA.join();
            threadB.join();
        } catch (Exception e) {}

        System.out.println("총 객체 수:" + list.size());
        System.out.println();
    }
}
