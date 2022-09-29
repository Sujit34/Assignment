package Lab7.Problem3;

import java.util.LinkedList;

public class Main {
	
	LinkedList<Integer> tempList = new LinkedList<>();
	public LinkedList<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {	
		
		if(list1.isEmpty() && list2.isEmpty()) return tempList;
		
		else if(!list1.isEmpty() && !list2.isEmpty()) {
			if(list1.get(0)<=list2.get(0))
			{
				tempList.add(list1.get(0));
		    	list1.remove();
			}
			else
			{
			    tempList.add(list2.get(0));
			    list2.remove();
			}
		}
		
		else if(!list1.isEmpty() && list2.isEmpty()) {			
				tempList.add(list1.get(0));
		    	list1.remove();			
		}
		
		else if(list1.isEmpty() && !list2.isEmpty()) {			
			tempList.add(list2.get(0));
	    	list2.remove();			
	    }
		
		
		merge(list1,list2);   	
		
		return tempList;
	}
	/*
	 private LinkedList<Integer> list3 = new LinkedList<>();
	
	public LinkedList<Integer> merge(LinkedList<Integer> list1, LinkedList<Integer> list2) {
		if (list1.size() == 0 && list2.size() == 0) {
			return list3;
		} else if (list1.size() == 0 && list2.size() > 0) {
			list3.addLast(list2.pop());
		} else if (list2.size() == 0 && list1.size() > 0) {
			list3.addLast(list1.pop());
		} else {
		
			if (list1.peek() < list2.peek()) {
				list3.addLast(list1.pop());
			} else {
				list3.addLast(list2.pop());
			}
		}
		
		return merge(list1, list2);
	}
   */
	public static void main(String[] args) {
		
		LinkedList<Integer> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		
		list1.add(2);list1.add(5);list1.add(8);list1.add(11);
		list2.add(1);list2.add(3);list2.add(6);
		
		Main m = new Main();
		LinkedList<Integer>  list3 = m.merge(list1, list2);
		
		if(list3 != null) System.out.println(list3);
		
	}
}
