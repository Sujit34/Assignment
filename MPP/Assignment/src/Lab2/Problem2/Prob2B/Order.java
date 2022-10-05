package Lab2.Problem2.Prob2B;

import java.util.*;

public class Order {
	private int orderNumber;	
	private List<OrderLine> list = new ArrayList<>();
	
	Order(int orderNumber) {
		this.orderNumber = orderNumber;		
	}
	
	public void addNewOrderLine(int lineId) {
		list.add(new OrderLine(lineId, this));
	}
	
	public List<OrderLine> getOrderLines() {
		return list;
	}
	
	public String toString() {
		String msg = "Order: \n";
		for(OrderLine o : list) {
			msg += o.toString() + "\n";
		
		}
		return msg;
	}
}