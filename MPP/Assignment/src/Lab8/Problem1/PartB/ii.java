package Lab8.Problem1.PartB;

import java.util.function.Supplier;


public class ii {
	public static void main(String[] args) {
		Supplier<Double> methodRef = Math::random;
		System.out.println(methodRef.get());

		Supplier<Double> lambda = () -> Math.random();
		System.out.println(lambda.get());
		
	}
	
}