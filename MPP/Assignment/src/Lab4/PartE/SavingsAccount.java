package Lab4.PartE;

public class SavingsAccount extends Account {
	
	private double interestRate;
	protected double balance;

	public SavingsAccount( String accountId, double interestRate, double balance) {
		super(accountId);
		this.interestRate = interestRate;
		this.balance = balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	@Override
	public double computeUpdatedBalance() {
		return this.balance + (this.interestRate * this.balance);
	}
	
	@Override
	public String getAccountId() {
		return this.accountId;
	}
	

	@Override
	public double getBalance() {
		return this.computeUpdatedBalance();
	}

}
