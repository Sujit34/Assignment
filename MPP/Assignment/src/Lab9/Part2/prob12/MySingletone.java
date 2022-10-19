package Lab9.Part2.prob12;

import java.util.Optional;


public class MySingletone {
	private static int count = 0;
	private static MySingletone instance = new MySingletone();
	private MySingletone() {
		count++;
	}
	
	public static MySingletone getInstance() {
		return Optional.ofNullable(instance).orElseGet(() -> setAndGet());		
	}
	
	private static MySingletone setAndGet() {		
		return instance;
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 10; ++i) {
			getInstance();
		}
		System.out.println(count);
	}
}
