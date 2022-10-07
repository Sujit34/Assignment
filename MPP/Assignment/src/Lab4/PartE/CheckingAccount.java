package Lab4.PartE;

public class CheckingAccount extends Account {
	private double monthlyFee;
	protected double balance;

	public CheckingAccount(String accountId, double monthlyFee, double balance) {
		super(accountId);
		this.monthlyFee = monthlyFee;
		this.balance = balance;
 	}

	public double getMonthlyFee() {
		return monthlyFee;
	}

	@Override
	public double computeUpdatedBalance() {
		return this.balance - this.monthlyFee;
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
