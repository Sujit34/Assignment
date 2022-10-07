package Lab4.PartE;

import java.util.*;

public class Employee {
	private String name;
	private List<Account> accounts;
	
	public Employee(String name) {
		this.name = name;
		this.accounts = new ArrayList<>();
	}

	public double computeUpdatedBalanceSum() {
		double newBalance = 0.0;
		
		for (Account account : accounts) {
			newBalance += account.computeUpdatedBalance();
		}
		
		return newBalance;
	}

	public String getName() {
		return name;
	}
	
	public void addAccount(Account account) {
		accounts.add(account);
	}
}
