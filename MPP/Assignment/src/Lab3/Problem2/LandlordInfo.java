package Lab3.Problem2;

import java.util.*;

public class LandlordInfo {
	
	private List<Building> listOfBuildings;
	
	public LandlordInfo() {		
		listOfBuildings = new ArrayList<Building>();	
	}
	
	public Building addBuilding(Building building) {		
		listOfBuildings.add(building);
		return building; 
	}
	
	public List<Building> getBuildings() {
		return listOfBuildings;
	}
	
	public double calcProfits() {
		double profit = 0.0;
		for(Building building : listOfBuildings) {
			profit  = profit + building.calcProfits();
		}
		return profit;
	}

}
