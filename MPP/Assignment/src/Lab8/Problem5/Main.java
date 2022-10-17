package Lab8.Problem5;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Hello there", "Goodbye", "Back soon", 
				"Away", "On Vacation", "Everywhere you want to be");
		
		//a. Use a lambda expression instead of directly defining a Consumer
		list.forEach(x -> System.out.println(x.toUpperCase()));	
		
		
		//b. Use a method reference in place of your lambda expression in (a)
		list.forEach(Main::toUpper);
		
	}
	
	public static void toUpper(String x) {
		System.out.println(x.toUpperCase());
	}
}
