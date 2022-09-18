package Lab5.Problem1;

public class MySingleton {
	private static MySingleton instance;
	public static int count = 0;
	
	// initialized immediately
	static {
		MySingleton instance  = new MySingleton(); 
		count++;
	}
	
	//private constructor so anybody can't access
	private MySingleton() {}
	
	/* When getInstance method will call it will check instance is already created or not.
	 * If not created then it will create new one. But in this case will not create any
	 *  new instance because instance already created in static block
	 */
	
	public static MySingleton getInstance() {
		if(instance == null) {
			instance = new MySingleton();
		}
		return instance;
	}
	
	/*
	 * As loop is running from 0-10 so it is an example of multiple client access. 
	 * In this case only one instance will create because always it calls getInstance method
	 * which will prevent to create multiple instance by checking null
	 */
	public static void main(String[] args) {
		
		for(int i = 0; i < 10; ++i) {
			MySingleton.getInstance();
		}
		System.out.println(count); // output is 1; As it creates instance once so class is singletone
	}
	
}
