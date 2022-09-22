package Lab9.Problem1;

public class MyStack {
	private MyStringLinkedList list;
	private MyStringLinkedList.Node top;
	public MyStack() {
		list = new MyStringLinkedList();	    
	}
	
	public String pop() {
		if(top!=null) {
			String s = peek();	
			MyStringLinkedList.Node temp = top;
			top.value = null;
			top=temp.next;
			return s;
		}
		else {
			return null;
		}
		
		
	}
	public String peek() {
		if(top!= null) {			
			return top.value;
		}
		else {
			return null;
		}
		
	}
	
	public void push(String s) {
		top = list.add(s);
	}
	
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push("Bob");
		stack.push("Harry");
		stack.push("Alice");
		System.out.println("Popping..."+stack.pop());
		System.out.println("Peeking..."+stack.peek());
		System.out.println("Popping..."+stack.pop());
		
		
		
	}	
}
