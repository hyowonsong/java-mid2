package thisisjava.ch17.stream_extra.ex03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortedExam01 {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("하이1", 22, 80, "컴퓨터1"),
				new Student("하이2", 32, 70, "컴퓨터2"),
				new Student("하이3", 42, 60, "컴퓨터3"),
				new Student("하이4", 52, 50, "컴퓨터4"),
				new Student("하이5", 62, 80, "컴퓨터5")
		);

		System.out.println("----- Comparable 사용  --------");
		list.stream().sorted().forEach(System.out :: println);

		System.out.println("----- Comparator.reverseOrder() 사용 : 내림차순 --------");

		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out :: println);
		
		System.out.println("----------------------");
		
		System.out.println();
		System.out.println("-------------나이 기준 정렬----------------------");
		list.stream()
			// 나이를 기준으로 정렬
			// .sorted((s1,s2) -> s1.getAge() - s2.getAge()) // 오름차순
			// .sorted((s1,s2) -> s2.getAge() - s1.getAge()) // 내림차순
			
			// stream 에서 Comparator.comparingInt 제공
			.sorted(Comparator.comparingInt(Student :: getAge))
			.forEach(System.out :: println);
	}

}











