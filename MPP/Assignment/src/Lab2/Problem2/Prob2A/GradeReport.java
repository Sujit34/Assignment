package Lab2.Problem2.Prob2A;

public class GradeReport {
	private Student student;
	private String grade;
	
	GradeReport(Student student) {
		this.student = student;		
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Student getStudent() {
		return student;
	}
	public String getGrade() {
		return grade;
	}
	
	@Override
	public String toString() {
		return grade;
	}
}