package collection.list.test.re_ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class ListEx2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("n개의 정수를 입력하세요 (종료 0)");
        while (true) {
            int input = scanner.nextInt();
            if (input == 0) {
                break;
            }
            numbers.add(input);
        }

        for (int i=0; i< numbers.size(); i++){
            System.out.println(numbers.get(i));
            if (i< numbers.size()-1){
                System.out.println(", ");
            }
        }
    }

}
