package Lab10.prob6;

public class addQueueNotThreadSafe {

	static Object ob = new Object();
	static QueueNotThreadSafe q = new QueueNotThreadSafe();
	
	public static void startThread() {
		Runnable r = () -> {
			for (int i = 0; i< 10; ++i) {
				q.add(ob);
				System.out.println("Added queue element: " + i);
			}
			
		};
		new Thread(r).start();
	}
	
	public static void main(String[] args) {
		for(int i=0; i<10; ++i) {
			startThread();
			System.out.println("=====Main Thread #: " + i + "======");
			System.out.println(q.count());
		}			
	}

	/* You can see from the result that each thread create unstable element and total count is not what we wanted*/
}
