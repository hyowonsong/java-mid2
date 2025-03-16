package thisisjava.ch17.stream_extra.ex03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MatchStreamExam02 {

	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("하이1", 22, 80, "컴퓨터1"),
				new Student("하이2", 32, 70, "컴퓨터2"),
				new Student("하이3", 42, 60, "컴퓨터3"),
				new Student("하이4", 52, 50, "컴퓨터4"),
				new Student("하이5", 62, 80, "컴퓨터5")
		);
		
		// 전부다 최종 연산자이다. 
		
		// 1. allMatch -> allMatch 안은 boolean 연산자
		boolean re = list.stream().allMatch((s)-> s.getScore() >= 50);		
		System.out.println("allMatch = " + re);
		
		// 2. anyMatch -> 학생중에 80점 이상이 한명이라도 있는지
		boolean re2 = list.stream().anyMatch((s)-> s.getScore() >= 80);
		System.out.println("anyMatch = " + re2);
		
		
		// 3. noneMatch -> 80 이상이 아무도 없니?
		boolean re3 = list.stream().noneMatch((s)-> s.getScore() >= 85);
		System.out.println("anyMatch = " + re3);
		
		// 4. max() 가장 많은 나이
		Student st = list.stream().max((s1, s2)-> s1.getAge() - s2.getAge()).orElse(null);
		
		System.out.println(st);
		
		IntStream stream = Arrays.stream(new int[] {1,3,5,6,8});
		int max = stream.max().getAsInt();
		System.out.println("max = " + max);
		
		stream = Arrays.stream(new int[] {1,3,5,6,8});
		int min = stream.min().getAsInt();
		System.out.println("min = " + min);
	}
}




















