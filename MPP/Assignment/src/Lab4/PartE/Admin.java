package Lab4.PartE;

import java.util.*;

public class Admin {
	public static double computeUpdatedBalanceSum(List<Employee> list) {
		double updatedBalance = 0.0;
		
		for (Employee employee : list) {
			updatedBalance += employee.computeUpdatedBalanceSum();
		}
		
		return updatedBalance;
	}
}
