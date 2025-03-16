package thisisjava.ch17.stream_extra.ex02;

import java.util.Arrays;
import java.util.List;

public class FilterStreamExam02 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("하이1", "하이2","하이3","하이4","하이5","하이6","하이7");
		
		System.out.println("1. 중복행 제거");
		long count = list.stream().distinct().count();
		System.out.println("개수 : " + count);
		System.out.println();
		
		// 여기 list 는 .stream() 해주면 그냥 stream() 생긴다. - > filter는 결국 boolean 이 나와야
		list.stream().distinct().forEach(System.out :: println);
		System.out.println();
		
		System.out.println("1. filter 요소 걸러내기");
		
		
		list.stream().filter((s)-> s.equals("하이1")).forEach(System.out :: println);;
		System.out.println();
		
		list.stream().filter((s)-> s.startsWith("하")).forEach(System.out :: println);;
		System.out.println();
		
		list.stream().filter((s)->s.endsWith("1")).forEach(System.out :: println);;
		System.out.println();
	}
}





























