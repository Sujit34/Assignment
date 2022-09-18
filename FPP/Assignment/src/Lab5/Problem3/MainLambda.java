package Lab5.Problem3;

import java.util.Arrays;


public class MainLambda {
	static boolean ascending;
	MainLambda(boolean ascending) {
		this.ascending = ascending;
	}
	
	public static void main(String[] args) {		
		
		StringSort ss = new StringSort((o1,o2)->ascending ? (o1.length() - o2.length()):(o2.length() - o1.length()));

		String[] testStrings = { "andy", "mike", "joe", "allen", "stephan" };
		ss.stringSort(testStrings);

		System.out.println(Arrays.asList(testStrings));
	}
}
