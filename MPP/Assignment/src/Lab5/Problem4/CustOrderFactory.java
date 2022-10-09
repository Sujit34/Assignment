package Lab5.Problem4;

import java.time.LocalDate;

public class CustOrderFactory {
	public static Customer getCustomerWithOrder() {
		Customer cust = new Customer("Sujit");
		
		Order order = Order.newOrder(cust, LocalDate.now());
		order.addItem("Juice");
		order.addItem("Cookies");

		order = Order.newOrder(cust, LocalDate.now());
		order.addItem("Chips");
		order.addItem("Soft Drinks");
		
		order = Order.newOrder(cust, LocalDate.now());
		
		return cust;
	}
}
