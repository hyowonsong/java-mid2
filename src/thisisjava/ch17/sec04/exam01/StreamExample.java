package thisisjava.ch17.sec04.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        //List 컬렉션 생성
        List<Product> list = new ArrayList<>();
        for (int i = 1; i<= 5; i++) {
            Product product = new Product(i, "상품"+i, "멋진회사", (int)(1000*Math.random()));
            list.add(product);
        }

        //객체 스트림 얻기
        Stream<Product> stream = list.stream();
        // Stream.forEach() 내부에서 Consumer<T> 함수형 인터페이스를 요구하기 때문에
        // 람다식이 자동으로 Consumer<T>의 accept(T t) 구현체로 매핑됨
        stream.forEach(product->System.out.println(product));
    }
}