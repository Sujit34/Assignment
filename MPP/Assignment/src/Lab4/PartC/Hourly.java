package Lab4.PartC;

public class Hourly extends Employee{
	
	private final int weekPerMonth = 4;
	private double hourlyWage;
	private int hoursPerWeek;	
	
	public Hourly(int empId, double hourlyWage, int hoursPerWeek) {
		super(empId);
		this.hourlyWage = hourlyWage;
		this.hoursPerWeek = hoursPerWeek;
	}

	public double getHourlyWage() {
		return hourlyWage;
	}

	public int getHoursPerWeek() {
		return hoursPerWeek;
	}

	public void setHourlyWage(double hourlyWage) {
		this.hourlyWage = hourlyWage;
	}

	public void setHoursPerWeek(int hoursPerWeek) {
		this.hoursPerWeek = hoursPerWeek;
	}

	
	
	@Override
	public double calcGrossPay(int month,int year) {
		return weekPerMonth * hoursPerWeek * hourlyWage;
	}
}
