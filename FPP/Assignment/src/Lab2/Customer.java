package Lab2;

public class Customer {
	
	static final String IMPORTANT_FIRST = "Sujit Kumar";
	static final String IMPORTANT_LAST =  "Chanda";
	private String firstName;
	private String lastName;	
	private String  socSecurityNum;
	private Address billingAddress;
	private Address shippingAddress;
	
	//Default
	public Customer() {
		this(IMPORTANT_FIRST, IMPORTANT_LAST);
	}
	
	public Customer(String fName, String lName) {
		firstName = fName;
		lastName = lName;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public String getSocSecurityNum() {
		return socSecurityNum;
	}
	public void setSocSecurityNum(String socSecurityNum) {
		this.socSecurityNum = socSecurityNum;
	}
	
	public Address getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(Address home) {
		this.billingAddress = home;
	}
	public Address getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(Address work) {
		this.shippingAddress = work;
	}
	
	
	public String toString() {
		return "[" + firstName + "," + lastName + ", ssn: "+ socSecurityNum + "]";
	}

}
