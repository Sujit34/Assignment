package Lab8.Problem6;

import java.util.Comparator;
import java.util.function.*;


public class Examples {
	
	
	Function<String, String> upperCase1 = (String x) -> x.toUpperCase();
	Function<String, String> upperCase2 = String::toUpperCase;
	
	
	Function<Employee, String> getName1 = e -> e.getName();
	Function<Employee, String> getName2 = Employee::getName;
	
	
	BiConsumer<Employee, String> setName1 = (e,s) -> e.setName(s);
	BiConsumer<Employee, String> setName2 = Employee::setName;
	

	Comparator<String> compare1 = (s1,s2) -> s1.compareTo(s2);
	Comparator<String> compare2 = String::compareTo;
	
	
	BiFunction<Integer, Integer, Double> power1 = (x,y) -> Math.pow(x,y);
	BiFunction<Integer, Integer, Double> power2 = Math::pow;	
	
	
	Function<Apple, Double> appleWeight1 = (Apple a) -> a.getWeight();
	Function<Apple, Double> appleWeight2 = Apple::getWeight;
	
	
	Function<String, Integer> parserInt1 = x -> Integer.parseInt(x);
	Function<String, Integer> parserInt2 = Integer::parseInt;
	
	
	EmployeeNameComparator compare = new EmployeeNameComparator();
	Comparator<Employee> employeeCompare1 = (e1, e2) -> compare.compare(e1,e2);
	Comparator<Employee> employeeCompare2 = this.compare::compare;
	
	
	public void evaluator() {
		Employee emp = new Employee("Sujit", 110000);
		Apple apple = new Apple(6);
		System.out.println(upperCase1.apply("Sujit"));
		System.out.println(upperCase2.apply("Sujit"));
		
		setName1.accept(emp,"Sujit");
		setName2.accept(emp,"Sujit1");
		
		System.out.println(getName1.apply(emp));
		System.out.println(getName2.apply(emp));
		
		
		System.out.println(compare1.compare("Sujit", "Sujit"));
		System.out.println(compare1.compare("Sujit", "Sujit"));
		
		System.out.println(power1.apply(3,3));
		System.out.println(power2.apply(3,3));
		
		System.out.println(appleWeight1.apply(apple));
		System.out.println(appleWeight1.apply(apple));
		
				
		System.out.println(parserInt1.apply("6"));
		System.out.println(parserInt2.apply("6"));
		
		System.out.println(employeeCompare1.compare(emp, new Employee("Sujit", 110000)));
		System.out.println(employeeCompare2.compare(emp, new Employee("Sujit", 110000)));
		
		
	}
	
	public static void main(String[] args) {
		Examples e = new Examples();
		e.evaluator();
		
	}	
}

