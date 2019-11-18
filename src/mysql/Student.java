package mysql;

public class Student {
	private int id;
	private String name;
	private String english;
	private String math;
	private String computer;

	public Student(int id, String name, String english, String math, String computer) {
		this.id = id;
		this.name = name;
		this.english = english;
		this.math = math;
		this.computer = computer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getMath() {
		return math;
	}

	public void setMath(String math) {
		this.math = math;
	}

	public String getComputer() {
		return computer;
	}

	public void setComputer(String computer) {
		this.computer = computer;
	}

}
