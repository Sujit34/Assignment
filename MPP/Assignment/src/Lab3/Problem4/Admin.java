package Lab3.Problem4;

import java.util.*;

public class Admin {
	public static double computeTotalRent(Object[] properties) {
		double totalRent = 0;
		for (Object o : properties) {
			if (o instanceof House) {
				House h = (House) o;
				totalRent += h.computeRent();
			}
			else if (o instanceof Condominiums) {
				Condominiums c = (Condominiums) o;
				totalRent += c.computeRent();
			}
			else if (o instanceof Trailer) {
				Trailer t = (Trailer) o;
				totalRent += t.computeRent();
			}	
		}
		return totalRent;
	}
	
	public static List<Object> findPropertiesInSameCity(Object[] properties,String city) {
				
		List<Object> listOfProperties = new ArrayList<Object>();
		for(Object o : properties) {
			if (o instanceof House) {
				House h = (House) o;
				if(h.address.getCity().equals(city))
				listOfProperties.add(o);
			}
			else if (o instanceof Condominiums) {
				Condominiums c = (Condominiums) o;
				if(c.address.getCity().equals(city))
					listOfProperties.add(o);
			}
			else if (o instanceof Trailer) {
				Trailer t = (Trailer) o;
				if(t.address.getCity().equals(city))
					listOfProperties.add(o);
			}
		}
		
		return listOfProperties;
	}
}
