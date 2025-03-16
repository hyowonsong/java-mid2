package thisisjava.ch17.stream_extra.ex01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Test00 {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				 new Student("희정", 22, 88.5, "Computer Science"), 
                 new Student("가현", 24, 76.2, "Mathematics"), 
                 new Student("찬범", 23, 92.3, "Computer Science"), 
                 new Student("현솔", 25, 81.7, "Physics")
		);
		
		//점수 80 이상인 학생->점수 기준 오름차순 정렬 후 -> 이름만 모아서 리스트로 만들기
		
		// 1. 기존 방식
		List<Student> scoreList = new ArrayList<Student>();
		
		
		for (Student st : students) {
			if (st.getScore() >= 80) {
				scoreList.add(st);
			}
		}
		
		Collections.sort(scoreList, (s1,s2)-> {
			double re =  s1.getScore() - s2.getScore();
			if (re == 0.0) return 0;
			else if (re > 0.0) return 1;
			else return -1;
		});
		
		// 이름만 뽑는 리스트
		List<String> names = new ArrayList<String>();
		for(Student st : scoreList) {
			names.add(st.getName());
		}
		
		// 출력
		for (String name : names) {
			System.out.println(name);
		}

		// 2. Stream 이용 방식
		System.out.println("=== 2. Stream 이용방식 ===");
		List<String> finishList = students.stream()
			.filter(s -> s.getScore() >= 80)
			// Student 클래스 안의 getScore 호출
			.sorted(Comparator.comparingDouble(Student :: getScore))
			.map(s-> s.getName())
			.toList();
		
		// 1. 기본 방식
		/*
		finishList.forEach(new Consumer<String>() {
			@Override
			public void accept(String name) {
				System.out.println(name);
			}
		});
		*/
		
		
		
		// 3. 스트림 방식
		finishList.forEach(System.out :: println);
	}
}




















