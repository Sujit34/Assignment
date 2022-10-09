package Lab5.Problem4;

import java.util.*;

public class Customer implements ICustomer {
	private String name;
	private List<Order> orders;
	public Customer(String name) {
		this.name = name;
		orders = new ArrayList<Order>();	
	}
	
	@Override
	public void addOrder(Order order) {
		orders.add(order);
	}
	public String getName() {
		return name;
	}
	
	@Override
	public List<Order> getOrders() {
		return orders;
	}
}
