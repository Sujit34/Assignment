package Lab4.PartE;

public abstract class Account {
	
	protected String accountId; 
	
	protected Account(String accountId) {
		this.accountId = accountId;
	}

	public abstract String getAccountId();

	public abstract double getBalance();
	
	public abstract double computeUpdatedBalance();
	
}