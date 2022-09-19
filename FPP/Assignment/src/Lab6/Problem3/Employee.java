package Lab6.Problem3;

import java.time.LocalDate;

public class Employee {

	private Account savingsAcct;
	private Account checkingAcct;
	private Account retirementAcct;
	private String name;
	private LocalDate hireDate;

	public Employee(String name, int yearOfHire, int monthOfHire, int dayOfHire) {
		this.name = name;
		this.hireDate = LocalDate.of(yearOfHire, monthOfHire, dayOfHire);
	}

	public void createNewChecking(double startAmount) {
		this.checkingAcct = new Account(this, AccountType.CHECKING, startAmount);
	}

	public void createNewSavings(double startAmount) {
		this.savingsAcct = new Account(this, AccountType.SAVINGS, startAmount);
	}

	public void createNewRetirement(double startAmount) {
		this.retirementAcct = new Account(this, AccountType.SAVINGS, startAmount);
	}

	public String getFormattedAcctInfo() {
		StringBuilder s = new StringBuilder();
		s.append("\nAccount Info For " + this.name + ": \n \n");
		if (checkingAcct != null) {
			s.append(checkingAcct.toString() + "\n");
		}
		if (savingsAcct != null) {
			s.append(savingsAcct.toString() + "\n");
		}
		if (retirementAcct != null) {
			s.append(retirementAcct.toString());
		}		
		return s.toString();

	}

	public void deposit(AccountType acctType, double amt) {
		switch (acctType) {
		case CHECKING:
			this.checkingAcct.makeDeposit(amt);
			break;
		case SAVINGS:
			this.savingsAcct.makeDeposit(amt);
			break;
		case RETIREMENT:
			this.retirementAcct.makeDeposit(amt);
			break;
		default:
			System.out.println("Sorry, this is wrong account type ");

		}
	}

	public boolean withdraw(AccountType acctType, double amt) {
		switch (acctType) {
		case CHECKING:
			return this.checkingAcct.makeWithdrawal(amt);
		case SAVINGS:
			return this.savingsAcct.makeWithdrawal(amt);
		case RETIREMENT:
			return this.retirementAcct.makeWithdrawal(amt);
		default:
			System.out.println("Sorry, this is wrong account type ");
			return false;
		}
	}

}
