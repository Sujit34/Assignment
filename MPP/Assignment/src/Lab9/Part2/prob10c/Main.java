package Lab9.Part2.prob10c;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		Stream<Integer> streams = Arrays.asList(1,2,3).stream();
		
		IntSummaryStatistics summaryStatistics
		   = streams.collect(Collectors.summarizingInt((Integer x)->x));
		
		System.out.println("Min = " + summaryStatistics.getMin()
						  + " Max = " + summaryStatistics.getMax());
		
	}
}
