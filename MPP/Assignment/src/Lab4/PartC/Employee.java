package Lab4.PartC;

import java.time.LocalDate;

public abstract class Employee {
	private int empId;
	
	
	public Employee(int empId) {		
		this.empId = empId;
	}

	public void print() {		
		Paycheck paycheck = calcCompensation(LocalDate.now().getMonthValue(), LocalDate.now().getYear());
		paycheck.print();
		
	}
	
	public Paycheck calcCompensation(int month,int year) {
		double grosspay = calcGrossPay(month,year);		
		Paycheck paycheck = new Paycheck (grosspay, .23 , .05, .01,.03,.075);		
		return paycheck;
	}
	
	public abstract double calcGrossPay (int month, int yr);
	
}
