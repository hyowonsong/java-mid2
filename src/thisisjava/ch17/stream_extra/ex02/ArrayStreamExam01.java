package thisisjava.ch17.stream_extra.ex02;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayStreamExam01 {

	public static void main(String[] args) {
		// Stream 은 기본적으로 자료구조가 있고 그것을 사용하는 것이다.
		String[] strArr = {"하이1","하이2","하이3","하이4","하이5"};
		/*for (String s: strArr) {
			System.out.println(s);
		}*/
		
		// 1. List, Collection은 List.stream() 가능하지만 배열은 static 이라서
		// Arrays.stream() 이렇게 할 수 있음
		
		System.out.println("1. String Array Stream ----------");
		// 1-1.이렇게 하면 람다
		Arrays.stream(strArr).forEach(t -> System.out.println(t));
		// 1-2. 이렇게 하면 메서드 참조 
		Arrays.stream(strArr).forEach(System.out :: println);
		
		// 1-3. Stream을 담아서 하는 방법
		Stream<String> stream = Arrays.stream(strArr);
		stream.forEach(System.out::println);
		
		// 이렇게 한번 더 사용하면 IllegalStateException 이 발생한다.
		// stream.forEach(System.out::println);
		
		// 2. intArr
		System.out.println("2. int Array Stream ----------");
		int[] intArr = {1,2,3,4,5,6,7,8,9};
		
		// 2-1. forEach -> of 가 Stream 이기 때문에 여기는 IllegalStateException 이 발생 X
		Arrays.stream(intArr).forEach(t -> System.out.println(t));

		IntStream.of(intArr).forEach(t -> System.out.println(t));
		
		IntStream.of(intArr).forEach(System.out :: println);
		IntStream.of(intArr).forEach(System.out :: println);
		
		/*
		IntStream stream1 = Arrays.stream(intArr);
		stream1.forEach(System.out::println);
		stream1.forEach(System.out::println);*/
		
		System.out.println("3. range() vs rangeClosed() ----------");
		IntStream.range(1, 10).forEach(System.out :: println); // 1~9
		System.out.println("--------------");
		IntStream.rangeClosed(1, 10).forEach(System.out :: println);
	}
}















































