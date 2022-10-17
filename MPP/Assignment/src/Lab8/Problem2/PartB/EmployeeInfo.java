package Lab8.Problem2.PartB;

import java.util.*;

public class EmployeeInfo {
	static enum SortMethod {BYNAME, BYSALARY};


	public void sort(List<Employee> emps, final SortMethod method) {
		class EmployeeComparator implements Comparator<Employee> {
			@Override
			public int compare(Employee e1, Employee e2) {
				if (method == SortMethod.BYNAME) {
					if (e1.name.compareTo(e2.name) != 0)
						return e1.name.compareTo(e2.name);
					return e1.salary > e2.salary ? 1 : e1.salary < e2.salary ? -1 : 0;
				} else {
					if(e1.salary > e2.salary) return 1;
					else if (e1.salary < e2.salary)
						return -1;
					else
						return e1.name.compareTo(e2.name);
				}
			}
		}
		Collections.sort(emps, new EmployeeComparator());
	}
	
	public static void main(String[] args) {
		List<Employee> emps = new ArrayList<>();
		emps.add(new Employee("Joe", 100000));
		emps.add(new Employee("Tim", 50000));
		emps.add(new Employee("Andy", 60000));
		EmployeeInfo ei = new EmployeeInfo();
		ei.sort(emps, EmployeeInfo.SortMethod.BYNAME);
		System.out.println(emps);
		//same instance
		ei.sort(emps, EmployeeInfo.SortMethod.BYSALARY);
		System.out.println(emps);
		
	}
}
