package thisisjava.ch14.sec07.exam02;

public class PrintThread extends Thread {
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println("실행 중");
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("리소스 정리");
        System.out.println("실행 종료");
    }
}
