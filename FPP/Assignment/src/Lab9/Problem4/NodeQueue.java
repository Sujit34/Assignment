package Lab9.Problem4;

public class NodeQueue {
	/* stores the element at the front of the queue, if it exists */
	private Node head;
	
	/* stores the element at the end of the queue, if it exists */
	private Node tail;
	
	public void enqueue(String s) {		
		
		Node newNode = new Node();
		newNode.data = s;
		
		if(isEmpty()) {
			head = newNode;
			tail = head;			
		}
		else {
			tail.next = newNode;			
			tail = newNode;	
		}		
			
	}
	
	public String dequeue() throws QueueException {
		if(isEmpty()) throw new QueueException("Queue is empty!");
		
		Node tempNode = head;
		head = head.next;
		return tempNode.data;
	}	
	
	public String peek() throws QueueException {
		if(isEmpty()) throw new QueueException("Queue is empty!");
		return head.data;
	}
	public boolean isEmpty() {
		return head == null;
	}
	@Override
	public String toString() {
		if(isEmpty()) return "<empty queue>";
		return head.toString();
	}
}