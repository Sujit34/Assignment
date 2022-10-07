package Lab4.PartC;

import java.time.LocalDate;
import java.util.*;

public class Main {
	
	public static void main(String[] args) {	
		
		List<Employee> employees = new LinkedList<>();
		
		employees.add(new Hourly(2, 10, 40));
		employees.add(new Salaried(1, 6000));
		employees.add(new Commissioned(3, 3, 5000));	
			

		((Commissioned)employees.get(2)).addNewOrder(101, LocalDate.of(2022, 9, 3), 300);
		((Commissioned)employees.get(2)).addNewOrder(101, LocalDate.of(2022, 9, 4), 300);
		((Commissioned)employees.get(2)).addNewOrder(101, LocalDate.of(2022, 9, 5), 300);
			
		
		employees.forEach(employee -> employee.print());
		
		
	}

}
