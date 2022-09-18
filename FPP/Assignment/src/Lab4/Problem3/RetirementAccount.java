package Lab4.Problem3;

import Lab3.Employee;

public class RetirementAccount extends Account {
	
	private AccountType accountType; 
	
	RetirementAccount(Employee emp, AccountType acctType, double balance){
		super(emp,acctType,balance);
		this.accountType = acctType;
	}
	
	public AccountType getAcctType() {
		return accountType.RETIREMENT;
	}
	
	@Override
	public double getBalance() {
		double baseBalance = super.getBalance();
		double penalty = (2/100)*baseBalance;
		return baseBalance - penalty;
	}


}
