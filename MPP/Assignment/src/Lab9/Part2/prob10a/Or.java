package Lab9.Part2.prob10a;

import java.util.*;

public class Or {

	public static void main(String[] args) {
		List<Simple> list = Arrays.asList(new Simple(false), new Simple(false), new Simple(true));
		System.out.println(someSimpleIsTrue(list));
		System.out.println(someSimpleIsTrueReduce(list));
	}
	
	public static boolean someSimpleIsTrue(List<Simple> list) {
		boolean accum = false;
		for(Simple s: list) {
			accum = accum || s.flag;
		}
		return accum;
	}
	public static boolean someSimpleIsTrueReduce(List<Simple> list) {
		return list.stream().map(s -> s.flag).reduce(false, (x, y) -> x || y);

	}

}
