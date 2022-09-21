package Lab8.Problem2;

public class MyStringLinkedList {
	Node header;
	MyStringLinkedList(){
		header = new Node(null);
	}
	//adds to the front of the list
	public void addFirst(String item){
		Node n = new Node(item);
		//place new node after header and 
		//establish links from new node to 
		//surrounding nodes
		n.next = header.next;
		n.previous = header;
		
		//establish links from surrounding 
		//nodes to the new node
		if(header.next != null){
			header.next.previous = n;
		}		
		header.next = n;	
	}
	
	//adds to the end of the list
	public void addLast(String item) {
		Node n = new Node(item);
		//find last node
		Node last = header;
		while(last.next != null) {
			last = last.next;
		}
		//now last.next == null
        last.next = n;
        n.previous = last;
	}
	
	//removes node in last position
	public void removeLast( ) {
		//if list is empty, return
		if(header.next == null) return;
		
		Node current = header;
		//traverse the list until current.next is 
		//null - then remove current
		while(current.next != null) {
			current = current.next;
		}
		//now current.next == null, so remove current
		Node previous = current.previous; 
		//previous is not null since current is not header
		previous.next = null;
		current.previous = null;
	}
	
	//determines whether the input string is in the list
	public boolean search(String s) {
		Node next = header.next;
		while(next != null && !next.value.equals(s)) {
			next = next.next;
		}
		//either next == null or next.value is s
		if(next == null) return false;
		else {//next.value.equals(s) 
			return true;		
		}
	}
	public String toString() { 
		var sb = new StringBuffer();
		Node next = header.next;
		while(next != null) {
			sb.append(next.toString() + ", ");
			next = next.next;
		}
		var result = sb.toString().trim();
		if(result.length() == 0) return "<empty list>";
		if(result.charAt(result.length()-1) == ',') {
			return result.substring(0,result.length()-1);
		}
		return result;			
	}
	class Node {
		String value;
		Node next;
		Node previous;
		Node(String value){
			this.value = value;
		}
		
		public String toString() {
			return value == null ? "null" : value;
		}
	}

	public static void main(String[] args){
		var list = new MyStringLinkedList();
		list.addLast("Rich");
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		list.addFirst("Bob");
		list.addFirst("Harry");
		list.addFirst("Steve");		
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		System.out.println(list.search("Harry"));
		System.out.println(list.search("Bob"));
		list.addLast("Tom");
		System.out.println(list);
		list.insert("Maharishi", 3);		
		System.out.println(list);
		System.out.println(list.remove("Maharishi"));
		System.out.println(list);
		list.minSort();
		System.out.println(list);
	}
	
	public void insert(String newElement, int position) {     
		  
		  //1. allocate node to new element
		  Node newNode = new Node(newElement); 
		  newNode.value = newElement;
		  newNode.next = null;
		  newNode.previous = null;

		  //2. check if the position is > 0
		  if(position < 1) {
		    System.out.println("\nposition should be >= 1.");
		  } 
		  else if (position == 1) {		    
		    //3. if the position is 1, make new node as head		    
			  addFirst(newElement);
		  } 
		  else {		    
		    //4. Else, make a temp node and traverse to the node previous to the position
		    Node temp = new Node(newElement);
		    temp = header;
		    for(int i = 1; i < position-1; i++) {
		      if(temp != null) {
		        temp = temp.next;
		      }
		    }
		 
		    //5. If the previous node is not null, adjust the links
		    if(temp != null) {
		      newNode.next = temp.next;
		      newNode.previous = temp;
		      temp.next = newNode;  
		      if(newNode.next != null)
		        newNode.next.previous = newNode;
		    } 
		    else {		      
		      //6. When the previous node is null
		      System.out.print("\nThe previous node is null.");
		    }       
		  }
		}  
	
	public boolean remove(String data) {
		Node next = header.next;
		while(next != null && !next.value.equals(data)) {
			next = next.next;
		}
		//either next == null or next.value is s
		if(next == null) return false;
		else {//next.value.equals(data)			
			
			// Change next only if node to be deleted
	        // is NOT the last node
	        if (next.next != null) {
	            next.next.previous = next.previous;
	        }
	 
	        // Change prev only if node to be deleted
	        // is NOT the first node
	        if (next.previous != null) {
	            next.previous.next = next.next;
	        }
	        return true;
		}
	}

	
	/******* sorting methods ********/
	public void minSort(){	
		
		Node current = null, index = null;        
        //Check whether list is empty  
        if(header == null) {  
            return;  
        }  
        else{        	  
            for(current = header.next; current.next != null; current = current.next) {
                index = minpos(current);	   
            	swap(current,index);                
            }
        }
	}
	void swap(Node n1, Node n2){		
		String temp = n1.value;
		n1.value = n2.value;
		n2.value = temp;		
	}
	
	
	public Node minpos(Node current){		
		Node index;
		Node temp = current;
		for(index = current.next; index != null; index = index.next) {
			if(current.value!=null && index.value!=null && index.value.compareTo(temp.value)<0) {
				temp = index;
			}
		}
		return temp;		
	}

	/********* end sorting methods ********/
}
