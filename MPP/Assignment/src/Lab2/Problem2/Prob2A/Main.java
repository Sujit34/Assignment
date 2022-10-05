package Lab2.Problem2.Prob2A;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		
		List<Student> listOfStudents = listOfStudents();
		grades(listOfStudents, new String[]{"A", "B", "A"});
		System.out.println(listOfStudents);	
		
	}
	private static List<Student> listOfStudents() {
		Student student1 = new Student("Sujit");		
		Student student2 = new Student("Bari");		
		Student student3 = new Student("Asif");
		
		return Arrays.asList(student1, student2, student3);
	}
	private static void grades(List<Student> list, String[] grades) {
		for(int i = 0; i < grades.length; ++i) {
			list.get(i).getGradeReport().setGrade(grades[i]);
		}
	}

}
