package Lab10.Problem1;

public class EmployeeBST {
	
private Node root;
private NameComparator nameComparator;
	

	//start with an empty tree
	public EmployeeBST (NameComparator nameComp) {
		root = null;
		nameComparator = nameComp;
	}
	/**
	 * Calls recursive find method to search
	 * for input Integer x; returns true if found,
	 * false otherwise. An iterative version
	 * can be built by modifying the insert
	 * method in this class.
	 * 
	 * @param x - Target Integer
	 * @return true if found, false otherwise
	 */
	public boolean find(Employee x) {
		if(x==null) return false;
		return find(x, root);
	}	
	
	/**
	 * Calls recursive find method to locate Node
	 * to be removed; then
	 * calls the recursive remove method to remove it.
	 * Returns true if target Node is found and
	 * is successfully removed, false otherwise
	 * 
	 * @param val - Integer to be removed
	 * @return true if found and removed, false otherwise
	 */
	public boolean remove(Employee val) {	
		Node node = findNode(val, root);
		return removeNode(node);	
	}
	
	/**
	 * Iterative implementation of insert operation
	 * (see slides for a recursive version). Note
	 * that this procedure assumes that client
	 * will not attempt to insert duplicate 
	 * values. If an attempt is made to insert a value
	 * already present in the tree, an IllegalArgumentException
	 * is thrown. 
	 * 
	 * @param x - Integer to be inserted
	 * @throws IllegalArgumentException if an attempt is made
	 * to insert a duplicate value.
	 */
	public void insert(Employee x) {
		if(find(x)) {
			return;
		}
		if (root == null) {
			root = new Node(x, null, null);
		}
		else {
			Node n = root;
			boolean inserted = false;
			while(!inserted) {
				//value x is smaller than node being examined -
				//go left unless left subtree is null, in which
				//case, insert data to the left
				if( nameComparator.compare(x, n.data) < 0) {
					//space found on the left
					if(n.left == null){
						n.left = new Node(x,null,null);
						inserted = true;
					}
					//left subtree not null; move left
					else {
						n = n.left;
					}
				}
				//value x is greater than node being examined -
				//go right unless right subtree is null, in which
				//case, insert data to the right
				else if( nameComparator.compare(x, n.data) > 0){ 
					//space found on the right					
					if(n.right==null){
						n.right = new Node(x,null,null);
						inserted = true;
					}
					else {
						n = n.right;
					}
				}
				//value x is equal to value found in node
				//--a duplicate value -- so
				//an exception is thrown
                else { 
                    throw new IllegalArgumentException(
                    	"Duplicate value passed in!");
           
                }	
			}
		}
	}	
	
	/**
	 * Calls recursive findMin method and returns
	 * the minimum value in the tree, or null if
	 * the tree is empty.
	 */
	public Employee findMin() {
		return findMin(root);
	}
	
	/**
	 * Prints the values in the nodes of the tree in sorted order.
	 * The work is done by the recursive printTree method.
	 * Printing is done by using an in-order traversal of the tree.
	 */
	public void printTree() {
		if (root == null)
			System.out.println("Empty tree");
		else
			printTree(root);
	}	
	
	
	///////// PRIVATE METHODS ///////////////

	private void printTree(Node t) {
		if (t != null) {
			printTree(t.left);
			System.out.println(t.data);
			printTree(t.right);
		}
	}
	
	private boolean removeNode(Node node) {
		if(node == null) return false;
		//in this case, we can just break the link
		//from node to its parent
		if(node.left == null && node.right== null) {
			Node parent = parent(node);
			if(parent != null) {
				if(parent.left == node) parent.left = null;
				if(parent.right == node) parent.right = null;
			}
			node = null;
			return true;
		}
		//in these cases, add a link from parent to 
		//child of node
		if(node.left != null && node.right == null ) {
			Node parent = parent(node);
			if(parent.left == node) parent.left = node.left;
			if(parent.right == node) parent.right = node.left;
			node = null;
			return true;
		}
		if(node.left == null && node.right != null ) {
			Node parent = parent(node);
			if(parent.left == node) parent.left = node.right;
			if(parent.right == node) parent.right = node.right;
			node = null;
			return true;
		}	
		
		//in this case, find min to the right of node and
		//insert this value into the node; link up parent of 
		//this min with right child of this min	
		if(node.left != null && node.right != null) {
			Node min = findMinNode(node.right);
			Node parentOfMin = parent(min);
			node.data = min.data;			
			parentOfMin.right = min.right;
			parentOfMin.left = null;
			return true;
		}
		return false;
	}
	private Node parent(Node t) {
		return parent(t,root,null);
	}
	private Node parent(Node t, Node n, Node parent) {
		if(n == null) return null;
		Employee val = t.data;
		if(n.data.equals(val)) return parent;
		if(nameComparator.compare(val, n.data) < 0) {
			return parent(t,n.left, n);
		}
		else {
			return parent(t,n.right,n);
		}
	}
	private Node findNode(Employee val) {
		return findNode(val, root);
	}
	private Node findNode(Employee val, Node n) {
		if(n == null) return null;
		if(n != null && n.data.equals(val)) return n;
		if(nameComparator.compare(val, n.data) < 0) {
			return findNode(val, n.left);
		}
		else {
			return findNode(val, n.right);
		}
	}
	private Employee findMin(Node t) {
		Node s = findMinNode(t);
		return s.data;
	}
	
	private Node findMinNode(Node t) {
		if(t==null) return null;
		while(t.left != null) {
			t = t.left;
		}
		return t;
	}

	private boolean find(Employee x, Node n){
		if(n == null) return false;
		if(n != null && n.data.equals(x)) return true;
		return ( nameComparator.compare(x, n.data) < 0) ?
				find(x, n.left) :
				find(x, n.right);
		
	}	

	class Node {
		private Employee data; // The data in the node
		private Node left; // Left child
		private Node right; // Right child
		
		Node(Employee theElement) {
			this(theElement, null, null);
		}
		Node(Employee element, Node left, Node right) {
			this.data = element;
			this.left = left;
			this.right = right;
		}
		public String toString() {
			return data.toString();
		}	
	}
}
