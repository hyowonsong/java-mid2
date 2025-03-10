package generic.ex1;

public class BoxMain1 {
    public static void main(String[] args) {
        IntegerBox integerBox = new IntegerBox();
        integerBox.set(10); //오토 박싱
        Integer integer = integerBox.get();
        // 오토 박싱에 의해 int 가 Integer 라는 객체가 된다.
        System.out.println("integer = " + integer);

        StringBox stringBox = new StringBox();
        stringBox.set("hello");
        String str = stringBox.get();
        System.out.println("str = " + str);

        // 문제 : 이후에 `Double`, 'Boolean` 을 포함한 다양한 타입을 담는 박스가 필요하다면
        // 각각의 타입별로 DoubleBox, BooleanBox 와 같이 클래스를 새로 만들어야 한다.
        // 담는 타입이 수십개라면 문제가 생기게 된다.
    }
}
