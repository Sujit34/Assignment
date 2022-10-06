package Lab3.Problem2;

import java.util.*;


public class Building {
	private List<Apartment> listOfApartments = new ArrayList<Apartment>();
	private double maintainanceCost;
	
	Building(double maintainanceCost, double rent){
		this.maintainanceCost = maintainanceCost;	
		addApartment(new Apartment(rent));
	}
	
	public void addApartment(Apartment appartment){
		listOfApartments.add(appartment);
	}
	
	public double calcProfits() {
		double profit = 0.0;
		for(Apartment app : listOfApartments) {
			profit = profit + app.getRent();
		}
		return profit - maintainanceCost;
	}
}
