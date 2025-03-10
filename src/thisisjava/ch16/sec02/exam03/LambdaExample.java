package thisisjava.ch16.sec02.exam03;

public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();

        // 매개변수가 두 개일 경우 (출력을 두개 하기 때문에 중괄호 필수!)
        person.action1((name, job) -> {
            System.out.print(name + "이 ");
            System.out.println(job + "을 합니다.");
        });

        person.action1((name, job) -> {
            System.out.print(name + "이 ");
            System.out.println(job + "을 하지 않습니다.");
        });

        person.action2(word->{
            System.out.print(word);
            System.out.println("라고 말합니다.");
        });

        person.action2(word-> System.out.println(word + "라고 외칩니다."));
    }
}
