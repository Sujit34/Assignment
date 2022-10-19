package Lab9.Part2.prob10b;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		System.out.println(Arrays.asList("Bill", "Thomas", "Mary").stream()
                				 .collect(Collectors.joining(", ")));
	}

}
