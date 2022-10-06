package Lab3.Problem4;


public class Trailer {
	
	private final double rent = 500;
	protected Address address;
	
	Trailer(String street,String city,String state,String zip){
		this.address = new Address(street,city,state,zip);
	}
	public double computeRent(){
		return rent;
	}
}
