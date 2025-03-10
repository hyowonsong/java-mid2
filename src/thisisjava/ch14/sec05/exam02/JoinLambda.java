package thisisjava.ch14.sec05.exam02;

public class JoinLambda {
    public static void main(String[] args) {
        final long[] sum = {0};

        Thread sumThread = new Thread(() -> {
            for (int i=1; i<=100; i++){
                sum[0] += i;
            }
        });

        sumThread.start();

        try {
            sumThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("1~100의 합 : " + sum[0]);
    }
}
