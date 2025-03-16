package thisisjava.ch17.stream_extra.ex04;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectStreamExam01 {
	public static void main(String[] args) {
		List<Student> totalList = new ArrayList<>(); 
		totalList.add(new Student("장희정", "남", 92)); 
		totalList.add(new Student("하승현", "여", 87)); 
		totalList.add(new Student("오문정", "남", 95)); 
		totalList.add(new Student("김은영", "여", 93)); 
		
		// 1. 학생들 중 남학생만 뽑아 새로운 List 로 만들자
		List<Student> menList = totalList.stream()
		.filter((s) -> s.getGender().equals("남"))
		.collect(Collectors.toList());
		
		// 1-1 collect 는 add 하면 잘 들어간다.
		menList.add(new Student("삼순이", "남", 85));
		
		menList.stream().forEach(System.out :: println);
		
		// 2. collect() 메서드 대신에 toList() 를 사용해보자.
		List<Student> menList2 = totalList.stream()
				.filter((s) -> s.getGender().equals("남"))
				.toList(); // java 16 추가
		
		
		// 2-1. toList() 를 사용하면 수정이 되지 않는다.
		// menList2.add(new Student("철이", "남", 66));
		
		menList2.stream().forEach(System.out :: println);
		System.out.println("----toMap<K, V> 사용해보자----");
		
		// 3. 학생들 정보를 이름을 key , 점수를 value 로 만들어서 Map 으로 리턴
		// Map 은 인수를 리턴
		Map<String, Integer> map = totalList.stream()
				// 3-1. 람다로 작업
				//.collect(Collectors.toMap((s) -> s.getName(),(s) -> s.getScore()));
				// 3-2. 메소드 참조로 작업
				.collect(Collectors.toMap(Student :: getName,Student :: getScore));
		System.out.println(map);
	}
}


















