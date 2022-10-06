package Lab3.Problem4;

public class Condominiums {
	private double numberOfFloors;	
	protected Address address;
	
	public Condominiums(String street,String city,String state,String zip,double numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
		this.address = new Address(street,city,state,zip);
	}

	public double computeRent(){
		return 400 * numberOfFloors;
	}

}
