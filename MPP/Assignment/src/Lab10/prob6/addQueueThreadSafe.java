package Lab10.prob6;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class addQueueThreadSafe {
	
	private static Executor exec = Executors.newCachedThreadPool();
	static Object ob = new Object();
	static QueueThreadSafe q = new QueueThreadSafe();
	
	
	public static void startThread() {
		Runnable r = () -> {
			for (int i = 1; i<=5; ++i) {
				q.add(ob);
				System.out.println("Added queue element: " + i);
			}
		};		
		exec.execute(r);
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {}
	}
	
	public static void main(String[] args) throws InterruptedException  {
		for(int i=1; i<=10; ++i) {
			System.out.println("=====Main Thread #: " + i + "======");
			startThread();
		}			
		System.out.println("-------------------------");
		System.out.println("Total queue element: " + q.count());
	}


}
