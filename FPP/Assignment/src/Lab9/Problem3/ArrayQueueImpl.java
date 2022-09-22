package Lab9.Problem3;

public class ArrayQueueImpl {
	private final int INITIAL_LENGTH = 2;
	private int[] arr ;
	private int size;
	private int front;
	private int rear;
	
	ArrayQueueImpl(){
		arr = new int[INITIAL_LENGTH];
		size = 0;
		front = -1;
		rear = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	
	public void enqueue(int value) {
		
		if(rear == arr.length) {
			resize(front);
		}
		
		if(rear==0)front=front+1;
		
		arr[rear]=value;
		rear=rear+1;	
		size=size+1;
		
	}
	
	
	public void dequeue() {
			if(arr==null) {
				throw new IllegalStateException("Nothing to deque ");
			}			
			front=front+1;
		}
	
	public int peek() {
		if(isEmpty()) throw new IllegalStateException("Cannot peek because Queue is empty!");
		if(front==-1) throw new IllegalStateException("Cannot peek because Queue is empty!");
		return arr[front];
	}
	
	public int size() {
		return size;
	}
	
	public void resize(int front) {
		System.out.println("resizing");
		int len = arr.length;
		int newlen = 2*len;
		int[] temp = new int[newlen];
		System.arraycopy(arr,0,temp,front,len);
		arr = temp;
	}
	
	
	public static void main(String[] args) {
		ArrayQueueImpl q = new ArrayQueueImpl();		
		
		for(int i = 0; i < 20; i ++)
			q.enqueue(i);		
		for(int i = 0; i < 14; i ++)
			q.dequeue();
		System.out.println(q.size());
		System.out.println(q.peek());
		for(int i=q.front;i<q.rear;i++) {
			System.out.print(q.arr[i]+" ");
		}
	}
}
