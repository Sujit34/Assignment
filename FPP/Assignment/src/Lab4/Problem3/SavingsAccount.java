package Lab4.Problem3;

import Lab3.Employee;

public class SavingsAccount extends Account {
	
	private AccountType accountType; 
	
	SavingsAccount(Employee emp, AccountType acctType, double balance){
		super(emp,acctType,balance);
		this.accountType = acctType;
	}
	
	public AccountType getAcctType() {
		return accountType.SAVINGS;
	}
	
	@Override
	public double getBalance() {
		double baseBalance = super.getBalance();
		double interest = (0.25/100)*baseBalance;
		return baseBalance + interest;
	}

}
