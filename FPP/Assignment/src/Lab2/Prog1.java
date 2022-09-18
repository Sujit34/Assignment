package Lab2;


public class Prog1 {
	public static void main(String[] args)
	{
		Address add1BillingAddress = new Address("1000 N 4th St.", "Fairfield", "IA", "52557");
		Address add1ShippingAddress = new Address("1000 N 4th St.", "Fairfield", "IA", "52557");
		Address add2BillingAddress = new Address("1000 N 4th St.", "Chicago", "Chicago", "52556");
		Address add2ShippingAddress = new Address("1000 N 4th St.", "Chicago", "Chicago", "52556");
		
		Customer cust1 = new Customer("Kumar", "Chanda");
		cust1.setSocSecurityNum("333-222-4444");
		cust1.setBillingAddress(add1BillingAddress);
		cust1.setShippingAddress(add1ShippingAddress);
		
		
		Customer cust2 = new Customer("Kumar", "Chanda");
		cust2.setSocSecurityNum("333-222-4444");
		cust2.setBillingAddress(add2BillingAddress);
		cust2.setShippingAddress(add2ShippingAddress);		
		
		
		Customer[] custArray = new Customer[2];
		custArray[0] = cust1;
		custArray[1] = cust2;
		
		for(int i = 0; i < custArray.length; ++i) {
			String city = custArray[i].getBillingAddress().getCity();
			if(city.equals("Fairfield")) {
				System.out.println(custArray[i].toString());
			}
		}
		
		
		String t = "Hello,strings can be fun. They have many uses.";
		String[] result = t.split(",| \\.");
		System.out.println(t);
		
	}

}
