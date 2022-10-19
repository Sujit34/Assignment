package Lab9.Part2.prob9;

import java.util.stream.Stream;

public class Square {
	public static void main(String[] args) {
		int limit = 4;		
		Stream<Integer> squares = Stream.iterate(1, n ->{
			return (int) Math.pow((int)Math.sqrt(n) + 1, 2);
			})
				.limit(limit);
		squares.forEach(x->System.out.println(x));
	}
}
