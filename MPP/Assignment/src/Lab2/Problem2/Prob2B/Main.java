package Lab2.Problem2.Prob2B;

import java.util.*;


public class Main {
	public static void main(String[] args) {
		Order order1 = new Order(1);
		order1.addNewOrderLine(10);
		order1.addNewOrderLine(20);
		order1.addNewOrderLine(30);
		
		Order order2 = new Order(2);
		order2.addNewOrderLine(40);
		order2.addNewOrderLine(50);
		order2.addNewOrderLine(60);
		
		Order order3 = new Order(3);
		order3.addNewOrderLine(70);
		order3.addNewOrderLine(80);
		order3.addNewOrderLine(90);
		
		
		List<Order> orders = Arrays.asList(order1, order2, order3);
		System.out.println(orders);
		
	

	}


}
