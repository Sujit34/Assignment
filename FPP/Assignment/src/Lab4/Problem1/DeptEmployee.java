package Lab4.Problem1;

import java.time.LocalDate;    
public class DeptEmployee {
	
	private String name;
	private double salary;
	private LocalDate hireDate;
	
	DeptEmployee(String name, double salary, int year, int month, int day)	
	{
		this.name = name;
		this.salary = salary;
		this.hireDate = LocalDate.of(year,month,day);
	}
	
	public String getName(String name)
	{
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public LocalDate getHireDate(LocalDate hireDate)
	{
		return this.hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	
	public double computeSalary()
	{
		return this.salary;
	}

}
