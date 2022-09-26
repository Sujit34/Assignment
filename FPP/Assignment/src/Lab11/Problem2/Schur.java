package Lab11.Problem2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Schur {
	
	boolean checkForSum(List<Integer> list, Integer z) {
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();		
		
		for (Integer x : list) {
			int keyToCheck = z - x;
			
			if (map.containsKey(keyToCheck)) {
				return true;
			} else {
				map.put(x, x);
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		Schur schur = new Schur();
		boolean isExists = false;
		
		Integer[] list1 = new Integer[] {1,2,3,4,3,4};
		int checkForSumList1 = 6;
		
		Integer[] list2 = new Integer[] {1,2,3,4,5,6};
		int checkForSumList2 = 16;
		
		isExists = schur.checkForSum(Arrays.asList(list1), checkForSumList1);
		
		System.out.println(Arrays.toString(list1));
		if (isExists) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		isExists = schur.checkForSum(Arrays.asList(list2), checkForSumList2);
		
		System.out.println(Arrays.toString(list2));
		if (isExists) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

}
