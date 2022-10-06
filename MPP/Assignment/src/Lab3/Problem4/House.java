package Lab3.Problem4;

public class House {
	private double lotSize;	
	protected Address address;
	
	public House(String street,String city,String state,String zip,double lotSize) {
		this.lotSize = lotSize;
		this.address = new Address(street,city,state,zip);
	}

	public double computeRent(){
		return 0.1 * lotSize;
	}

}
