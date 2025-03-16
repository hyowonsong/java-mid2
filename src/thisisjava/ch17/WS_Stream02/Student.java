package thisisjava.ch17.WS_Stream02;

public class Student {
	private String name;
	private String gender;
	private int score;

	public Student(String name, String gender, int score) {
		this.name = name;
		this.gender = gender;
		this.score = score;
	}

	public String getName() { return name; }
	public String getGender() { return gender; }
	public int getScore() { return score; }

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Student{");
		sb.append("name='").append(name).append('\'');
		sb.append(", gender='").append(gender).append('\'');
		sb.append(", score=").append(score);
		sb.append('}');
		return sb.toString();
	}
}
