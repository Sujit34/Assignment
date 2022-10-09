package Lab5.Problem4;

public class Main {
	public static void main(String[] args) {
		ICustomer cust = CustOrderFactory.getCustomerWithOrder();
		System.out.println(cust.getOrders());
	}
}
