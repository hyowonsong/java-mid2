package thisisjava.ch17.stream_extra.ex02;

import java.util.Arrays;
import java.util.List;

// filter 는 오리지널 제네릭, Map 은 Filter 로 변경하고 싶을 때 사용
public class MapStreamExam03 {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("하이1", 22, 80, "컴퓨터1"),
				new Student("하이2", 32, 70, "컴퓨터2"),
				new Student("하이3", 42, 60, "컴퓨터3"),
				new Student("하이4", 52, 50, "컴퓨터4"),
				new Student("하이5", 62, 80, "컴퓨터5")
		);
		
		// 이렇게 . 으로 연결하는 것을 메서드 체인 기법
		
		// 전체 출력
		list.stream().forEach(System.out :: println);
		
		// 점수만 출력 -> 이미 리턴 타입이 무엇인지 아니까 그냥 map 말고 mapToInt 사용
		// 1. 람다로 사용
		list.stream().mapToInt(s -> s.getScore())
				.forEach(System.out :: println);
		
		// 1-2. 메서드 참조로 사용
		list.stream().mapToInt(Student :: getScore)
		.forEach(System.out :: println);

		System.out.println();
		
		// 점수의 총점
		int sum = list.stream().mapToInt(Student :: getScore).sum();
		System.out.println(sum);
		System.out.println("점수의 합계 : " + sum);
		System.out.println();
		
		// 점수의 평균
		double avg = list.stream()
				.mapToInt(Student :: getScore)
				.average()
				.orElse(0.0);
		
		System.out.println("점수의 평균 : "  + avg);
		System.out.println();
		
		// 인원수 
		long count = list.stream().mapToInt(Student :: getScore).count();
		System.out.println("인원수 : " + count);
		
		
		// 점수가 80이상인 학생들의 이름만 검색
		// 람다로 사용
		list.stream()
		.map(s -> s.getName())
		.forEach(System.out :: println);
		
		System.out.println();
		list.stream()
		.filter(s->s.getScore() >=80)               // Stream<Student>
		.map(Student :: getName)                    // Stream<String>
		.forEach(System.out :: println);
	}
}













