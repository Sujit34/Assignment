package Lab8.Problem3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeSort {

	public static void main(String[] args) {
		new EmployeeSort();

	}
	public EmployeeSort() {
		Employee[] empArray =
			{new Employee("George", 40000, 1996,11,5),
			 new Employee("Dave", 50000, 2000, 1, 3),
			 new Employee("Richard", 45000, 2001, 2, 7)};
			 
		List<Employee> empList = Arrays.asList(empArray);
		
		//NameComparator		
		NameComparator nameComp = 
			new NameComparator();
		Collections.sort(empList, nameComp);
		System.out.println("---------------------------------------------------");
		System.out.println("Name Comparator:");
		System.out.println("---------------------------------------------------");
		System.out.println(empList+"\n");
		System.out.println("---------------------------------------------------");
		
		//SalaryComparator
		SalaryComparator salaryComp =
				new SalaryComparator();
		Collections.sort(empList,salaryComp);
		System.out.println("---------------------------------------------------");
		System.out.println("Salary Comparator:");
		System.out.println("---------------------------------------------------");
		System.out.println(empList);
		System.out.println("---------------------------------------------------");
		
		//HireDateComparator
		HireDateComparator hireDateComp =
				new HireDateComparator();
		Collections.sort(empList,hireDateComp);
		System.out.println("---------------------------------------------------");
		System.out.println("HireDate Comparator:");
		System.out.println("---------------------------------------------------");
		System.out.println(empList);
		System.out.println("---------------------------------------------------");
	}

}
