package thisisjava.ch17.stream_extra.ex05;

class Student { 
	 private String name; 
	 private int age; 
	 private double score; 
	 private String major; 
	 
	 public Student(String name, int age, double score, String major) { 
		 this.name = name; 
		 this.age = age; 
		 this.score = score; 
		 this.major = major; 
	 } 

	public String getName() { 
		 return name; 
	 } 
 
	 public int getAge() { 
		 return age; 
	 } 
 
	public double getScore() { 
		return score; 
	} 
 
	public String getMajor() { 
		return major; 
	}	 
 
	@Override 
	public String toString() { 
		return name + " (" + score + ")"; 
 	} 
}






