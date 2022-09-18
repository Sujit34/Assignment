package Lab4.Problem6.Case2;

import java.util.GregorianCalendar;

public class PersonWithJob extends Person {
	private double salary;
	PersonWithJob(String name, GregorianCalendar dob, double salary) {
		super(name, dob);
		this.salary = salary;
	}
	public double getSalary() {
		return salary;
	}
	
	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof PersonWithJob)) return false;
		PersonWithJob pj = (PersonWithJob)ob;
		return super.getName().equals(getName())
			&& super.getDateOfBirth().equals(getDateOfBirth()) 
			&& pj.getSalary() == getSalary() ;
	}
	
	public static void main(String[] args) {	
		
		boolean isEqual;
		
		PersonWithJob pr1 = new PersonWithJob("ABC", new GregorianCalendar(1999, 6, 27),6000);
		PersonWithJob pr2 = new PersonWithJob("ABC", new GregorianCalendar(1999, 6, 27),6000);
		isEqual = pr1.equals(pr2); 
		System.out.println(isEqual);
		
		PersonWithJob pr3 = new PersonWithJob("ABC", new GregorianCalendar(1999, 6, 27),5000);
		PersonWithJob pr4 = new PersonWithJob("XYZ", new GregorianCalendar(1999, 6, 27),6000);
		isEqual = pr3.equals(pr4); 
		System.out.println(isEqual);

	}
}
