package Lab5.Problem4;

import java.time.LocalDate;
import java.util.*;

public class Order {
	private LocalDate orderDate;
	private List<Item> items;
	
	private Order(LocalDate orderDate) {
		this.orderDate = orderDate;
		items = new ArrayList<Item>();	
	}
	public static Order newOrder(Customer cust, LocalDate date) {
		if(cust == null) throw new NullPointerException("Null customer");
		Order ord = new Order(date);
		cust.addOrder(ord);
		return ord;
	}
	public void addItem(String item){
		if(item == null) throw new NullPointerException("Null item");
		items.add(new Item(item));
	}
	@Override
	public String toString() {
		return orderDate + ": " +
	              items.toString();
	}
}
