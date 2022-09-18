package Lab4.Problem6.Case1;

import java.util.GregorianCalendar;

public class Person {

	private String name;
	private GregorianCalendar dateOfBirth;
	Person(String name, GregorianCalendar dob) {
		this.name = name;
		dateOfBirth = dob;
	}
	public String getName() {
		return name;
	}
	
	public GregorianCalendar getDateOfBirth() {
		return (GregorianCalendar)dateOfBirth.clone();
	}
	
	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof Person)) return false;
		Person p = (Person)ob;
		return p.name.equals(name) && p.dateOfBirth.equals(dateOfBirth);
	}
	
	public int hashCode() {
		int seed = 17;
		int result = 31 * seed + name.hashCode();
		result = 31 * result + dateOfBirth.hashCode();
		return result;
	}
	
	public static void main(String[] args) {	
		
		boolean isEqual;
		
		Person pr1 = new Person("ABC", new GregorianCalendar(1999, 6, 27));
		Person pr2 = new Person("ABC", new GregorianCalendar(1999, 6, 27));
		isEqual = pr1.equals(pr2); 
		System.out.println(isEqual);
		
		Person pr3 = new Person("ABC", new GregorianCalendar(1999, 6, 27));
		Person pr4 = new Person("XYZ", new GregorianCalendar(1999, 6, 27));
		isEqual = pr3.equals(pr4); 
		System.out.println(isEqual);

	}

}

