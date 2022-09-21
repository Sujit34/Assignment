package Lab8.Problem4;

import java.util.ArrayList;
import java.util.List;

public class Main {
	private List<Address> listOfAddresses;
	
	public static void main(String[] args) {
		Main m = new Main();
		m.loadData();
		m.printAsUpperCase();
	}
	private void loadData(){
		listOfAddresses = new ArrayList<>();
		listOfAddresses.add(new Address("Jim", "101 Adams", "Fairfield", "IA", "52556"));
		listOfAddresses.add(new Address("Tom", "30 W. Burlington", "Fairfield", "IA", "52556"));
		listOfAddresses.add(new Address("Hal", "14 E. Court", "Fairfield", "IA", "52556"));
		listOfAddresses.add(new Address("Sally", "410 W. Jefferson", "Fairfield", "IA", "52556"));
		listOfAddresses.add(new Address("MUM", "1000 N. 4th St", "Fairfield", "IA", "52556"));		

	}
	
	public void printAsUpperCase() {
		listOfAddresses.forEach(item->System.out.println(formatFields(item.toUpper())));	
	}
	
	private String formatFields(List<String> list) {
		StringBuilder output = new StringBuilder();
		String addressTypeFormat1 = "%s\n";
		String addressTypeFormat2 = "%s,";
		String addressTypeFormat3 = "%s ";
		
		for(int i=0;i<2;i++) {
			output.append(String.format(addressTypeFormat1, list.get(i)));
		}
		output.append(String.format(addressTypeFormat2, list.get(2)));
		for(int i=3;i<list.size();i++) {			
			output.append(String.format(addressTypeFormat3, list.get(i)));
		}
		output.append("\n");
		
		return output.toString();
	}
}
