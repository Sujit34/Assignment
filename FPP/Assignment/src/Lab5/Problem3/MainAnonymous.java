package Lab5.Problem3;

import java.util.Arrays;
import java.util.Comparator;

public class MainAnonymous {
	
	static boolean ascending;
	MainAnonymous(boolean ascending) {
		this.ascending = ascending;
	}
	
	public static void main(String[] args) {	
		
		
		StringSort ss = new StringSort(new Comparator<String>() {			
				public int compare(String o1, String o2) {
					return ascending ? (o1.length() - o2.length())   :
						(o2.length() - o1.length());}				
		});

		String[] testStrings = { "andy", "mike", "joe", "allen", "stephan" };
		ss.stringSort(testStrings);

		System.out.println(Arrays.asList(testStrings));
	}

}
