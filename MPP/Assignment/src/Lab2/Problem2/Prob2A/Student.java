package Lab2.Problem2.Prob2A;


public class Student {
	private String name;
	private GradeReport gradeReport;
	
	Student(String name) {
		this.name = name;
		gradeReport = new GradeReport(this);
	}
	
	public String getName() {
		return name;
	}
	
	public GradeReport getGradeReport() {
		return gradeReport;
	}
	
	@Override
	public String toString() {		
		return this.name + ": " + this.gradeReport;
	}
}