package Lab6.Problem3;

public class Account {	
	private final static double DEFAULT_BALANCE = 0.0;
	private double balance;
	private AccountType accountType;
	private Employee employee;

	Account(Employee employee2, AccountType acctType, double balance) {
		employee = employee2;
		accountType = acctType;
		this.balance = balance;
	}

	Account(Employee emp, AccountType acctType) {
		this(emp, acctType, DEFAULT_BALANCE);
	}
	
	Account(AccountType acctType,double balance) {
		this.accountType = acctType;
		this.balance = balance;
	}

	public String toString() {
		return "type = " + accountType + ", balance = " + balance;
	}

	public void makeDeposit(double deposit) {
		balance = balance + deposit;		
	}

	public boolean makeWithdrawal(double amount) {	
		if(amount<= balance)
		{
			balance = balance- amount;
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType acctType) {
		accountType = acctType;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double bal) {
		balance = bal;
	}
	
	
	private String accountTypeFormat = "Account Type: \t%s\n";
    private String accountBalanceFormat = "Current Bal:\t%.2f\n";

    public String getFormattedAcctInfo() {
        StringBuilder result = new StringBuilder();
        result.append(String.format(accountTypeFormat, this.accountType));
        result.append(String.format(accountBalanceFormat, this.balance));
        return result.toString();
    }
    
   
	
}

