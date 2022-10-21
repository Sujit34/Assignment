package Lab10.prob6;

import Lab10.prob6.QueueNotThreadSafe.Node;

//Show the methods are not threadsafe.
//Then modify so that they are threadsafe.
public class QueueThreadSafe {
	class Node {
		Object value;
		Node next;
	}
	private Node head;
	private Node tail;
	
	//Thread safe
	synchronized public void add(Object newValue) {
		Node n = new Node();
		if(head == null) head = n;
		else tail.next = n;
		tail = n;
		tail.value = newValue;
		count();
	}
	public Object remove() {
		if(head == null) return null;
		Node n = head;
		head = n.next;
		return n.value;
	}
	
	public int count() {
		int counter = 0;
		Node node = head;
		
		while(node!=null) {
			counter++;
			node = node.next;
		}
		
		return counter;
	}
}
