package Lab4.Problem1;

public class Secretary extends DeptEmployee{
	private double overtimeHours;
	
	
	Secretary(String name, double salary, int year, int month, int day, double overtimeHours){
		super( name,  salary,  year, month, day);
		this.overtimeHours = overtimeHours;
	}
	
	
	public double getOvertimeHours(double overtimeHours)
	{
		return this.overtimeHours;
	}
	public void setOvertimeHours(double overtimeHours) {
		this.overtimeHours = overtimeHours;
	}
	
	@Override
	public double computeSalary() {	
		double baseSalary = super.computeSalary();
		return baseSalary + this.overtimeHours*12;
	}

}
