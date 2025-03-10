package thisisjava.ch19.sec02;

import java.net.InetAddress;

public class InetAddressExample {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("내 컴퓨터 IP 주소: " + localHost.getHostAddress());

            InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
            for (InetAddress ia : iaArr) {
                System.out.println(ia.getHostAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
