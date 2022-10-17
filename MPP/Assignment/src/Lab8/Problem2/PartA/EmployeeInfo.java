package Lab8.Problem2.PartA;

import java.util.*;

public class EmployeeInfo {
	static enum SortMethod {BYNAME, BYSALARY};
	private SortMethod method;
	
	public EmployeeInfo(SortMethod method) {
		this.method = method;
	}
	//Comparators are unaware of the value in method
	public void sort(List<Employee> emps) {
		if(method == SortMethod.BYNAME) {
			Collections.sort(emps, new EmployeeNameComparator());
		}
		else if(method == SortMethod.BYSALARY) {
			Collections.sort(emps, new EmployeeSalaryComparator());
		}
	}
	public static void main(String[] args) {
		Employee joe1 = new Employee("Joe", 100000);
		Employee joe2 = new Employee("Joe", 100000);
		
		System.out.println(joe1.equals(joe2));
		
		EmployeeNameComparator nameComp = new EmployeeNameComparator();
		System.out.println(nameComp.compare(joe1, joe2));
		
	}
}