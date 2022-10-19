package Lab9.Part2.prob11b;

import java.util.List;
import java.util.stream.Collectors;


public class LambdaLibrary {
	public static final TriFunction<List<Employee>, Integer, Character, String> employee =
			(employees, salaryBound, letter) ->  employees.stream()
				        .filter(e -> (e.getSalary() > salaryBound))
				        .filter(e -> (e.getLastName().charAt(0) > letter))
				        .map(e -> Employee.fullName(e))
				        .sorted().collect(Collectors.joining(", "));
}
