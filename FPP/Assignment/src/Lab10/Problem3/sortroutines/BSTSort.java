package Lab10.Problem3.sortroutines;

import Lab10.Problem3.runtime.*;

public class BSTSort extends Sorter{
	
	
	
	public static void main(String[] args) {
		BSTSort bstSort = new BSTSort();
		int [] ipnutArray = new int[] {6,4,3,2,1,8,7,9,5};
		int[] result = bstSort.sort(ipnutArray);
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
		
	}
	
	public int[] sort(int[] arr) {		
		MyBST myBST = new MyBST();		
		myBST.insertAll(arr);
		int[] sortedArray = myBST.readIntoArray();		
		return sortedArray;
	}
}
