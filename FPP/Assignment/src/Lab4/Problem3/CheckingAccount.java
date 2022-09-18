package Lab4.Problem3;

import Lab3.Employee;

public class CheckingAccount extends Account {
	
	private AccountType accountType; 
	
	CheckingAccount(Employee emp, AccountType acctType, double balance){
		super(emp,acctType,balance);
		this.accountType = acctType;
	}
	
	public AccountType getAcctType() {
		return accountType.CHECKING;
	}
	
	@Override
	public double getBalance() {
		double baseBalance = super.getBalance();
		double serviceCharge = (5/100)*baseBalance;
		return baseBalance + serviceCharge;
	}

}
