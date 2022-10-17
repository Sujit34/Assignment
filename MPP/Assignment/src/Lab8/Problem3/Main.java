package Lab8.Problem3;

import java.util.*;
import java.util.function.BiFunction;

public class Main {
	public static void main(String[] args) {
		BiFunction<Double, Double, List<Double>> lambda =
			(x,y) -> { 
				List<Double> list = new ArrayList<>();
				list.add(Math.pow(x, y));
				list.add(x * y);
				return list;
			};
		System.out.println(lambda.apply(2.0, 3.0));
	}
}
