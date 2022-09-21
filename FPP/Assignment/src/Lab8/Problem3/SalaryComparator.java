package Lab8.Problem3;

import java.util.Comparator;
import java.util.Date;

public class SalaryComparator implements Comparator<Employee>{
	public int compare(Employee e1, Employee e2) {
		String name1 = e1.getName();
		String name2 = e2.getName();
		Date hireDate1 = e1.getHireDate();
		Date hireDate2 = e2.getHireDate();
		int salary1 = e1.getSalary();
		int salary2 = e2.getSalary();
		
		if(salary1 < salary2) {
			return -1;
		}
		else if(salary1 > salary2) {
			return 1;
		}
		else {
			if(hireDate1.compareTo(hireDate2) != 0) {
				return hireDate1.compareTo(hireDate2);
			}
			if(name1.compareTo(name2)<0) {
				return -1;
			}
			else if(name1.compareTo(name2)>0) {
				return 1;
			}
			else {
				return 0;
			}
		}	
	}
}
