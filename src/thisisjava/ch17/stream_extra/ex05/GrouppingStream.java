package thisisjava.ch17.stream_extra.ex05;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class GrouppingStream {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("하이1", 22, 80, "컴퓨터1"),
				new Student("하이2", 32, 70, "컴퓨터2"),
				new Student("하이3", 42, 60, "컴퓨터3"),
				new Student("하이4", 52, 50, "컴퓨터4"),
				new Student("하이5", 62, 80, "컴퓨터5")
				);
	
	System.out.println("1. 전공별 그룹핑......");
	Map<String, List<Student>> map = students.stream()
			.collect((Collectors.groupingBy(Student::getMajor)));
	
	map.forEach((major, studentsList) -> System.out.println(major + "=" + studentsList));
	
	System.out.println("2. 전공별 학생수 계산(counting).......");
	// 메서드 참조에서 추가로 더 넣을 수 있다.
	Map<String, Long> majorcountMap = students.stream()
	.collect(Collectors.groupingBy(Student :: getMajor, Collectors.counting()));
	
	System.out.println(majorcountMap);
	
	System.out.println("3. 전공별 점수이 평균....");
	Map<String, Double> averageMap = students.stream().collect(Collectors.groupingBy(Student :: getMajor, 
			Collectors.averagingDouble(Student :: getScore)));
	
	System.out.println(averageMap);
	}
}

































