package Lab11.Problem1;

import java.util.HashMap;
import java.util.Iterator;

public class Employee {
	private String firstName;
	private String lastName;
	private HashMap<String, Double> salaryRecord;
	
	public Employee() {
		salaryRecord = new HashMap<>();
	}
	
	public void addEntry(String date, double salary) {
		salaryRecord.put(date, Double.valueOf(salary));
	}
	
	public void printPaymentAmount(String date) {
		if (salaryRecord.containsKey(date)) {
			System.out.println(firstName + " " + lastName + " was paid " + salaryRecord.get(date) + " on " + date);
		} else {
			System.out.println(firstName + " " + lastName + " did not receive a paycheck on " + date);
		}
	}
	public void printAveragePaycheck() {
		double totalPaycheck = 0.0;
		
		Iterator<HashMap.Entry<String, Double>> iter = salaryRecord.entrySet().iterator();
		while (iter.hasNext()) {
			double value = iter.next().getValue();
			totalPaycheck += value;			
		}
		
		double avgeragePaycheck = totalPaycheck / salaryRecord.size();
		
		System.out.println("Average paycheck for " + firstName + " " + lastName + " was " + avgeragePaycheck);
	}
	
	public static void main(String[] args) {
		Employee e = new Employee();
		e.setFirstName("Jim");
		e.setLastName("Jones");
		for(int i = 1; i <= 12; ++i) {
			e.addEntry(i+"/15/2011", 3070+5*i);
		}
		e.printPaymentAmount("3/15/2011");
		e.printPaymentAmount("5/15/2010");	
		
		e.printAveragePaycheck();
		
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}

