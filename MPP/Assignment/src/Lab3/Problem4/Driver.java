package Lab3.Problem4;

import java.util.*;

public class Driver {
	public static void main(String[] args) {

		Object[] objects = new Object[] { new House("1000 N","Fairfield","IOWA","52557",9000.0), 
				new Condominiums("1000 N","Fairfield","IOWA","52557",2), 
				new Trailer("1000 N","Fairfield","IOWA","52557") };
		double totalRent = Admin.computeTotalRent(objects);
		System.out.println("Total rent is: " + totalRent);
		
		List<Object> properties = Admin.findPropertiesInSameCity(objects,"Fairfield");
		
		for(Object o : properties) {
			if (o instanceof House) {
				House h = (House) o;
				System.out.println(h.getClass().getSimpleName() + ":   Street:" + h.address.getStreet()+ ",   City:" + h.address.getCity() + ",   State:" + h.address.getState() + ",   Zip:" + h.address.getZip());
			}
			else if (o instanceof Condominiums) {
				Condominiums c = (Condominiums) o;
				System.out.println(c.getClass().getSimpleName() + ":   Street:" +  c.address.getStreet()+ ",   City:" + c.address.getCity()+ ",   State:" + c.address.getState() + ",   Zip:" + c.address.getZip());
			}
			else if (o instanceof Trailer) {
				Trailer t = (Trailer) o;
				System.out.println(t.getClass().getSimpleName() + ":   Street:" +t.address.getStreet()+ ",   City:" + t.address.getCity()+ ",   State:" + t.address.getState() + ",   Zip:" + t.address.getZip());
			}
		}
		
	}
}
