package thisisjava.ch17.stream_extra.ex01;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamExam01 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Alice", 
				"Bob", "Charlie", "David", "Alice", "Bob", "Charlie", "David"); 
		
		// 1. 기존방식
		for (String name : names) { 
		    if (name.startsWith("C")) { 
		        System.out.println(Thread.currentThread().getName() + " - " + name); 
		    } 
		} 
		
		// 2. 스트림 방식
		System.out.println();
		System.out.println("=====스트림 방식입니다====");
		names.parallelStream() 
	     .filter(name -> name.startsWith("C")) 
	     .forEach(name ->  
	         System.out.println(Thread.currentThread().getName() + " - " + name) 
	     ); 
	}
}
