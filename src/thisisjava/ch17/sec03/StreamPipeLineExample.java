package thisisjava.ch17.sec03;

import java.util.Arrays;
import java.util.List;

public class StreamPipeLineExample {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동1",10),
                new Student("홍길동2",20),
                new Student("홍길동3",30)
        );

        double avg = list.stream()
                .mapToDouble(Student::getScore)
                .average()
                .getAsDouble();

        System.out.println("평균 점수: " + avg);
    }
}
