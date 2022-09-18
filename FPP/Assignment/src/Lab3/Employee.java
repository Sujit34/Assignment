package Lab3;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
	// instance fields
	private String name;
	private String nickName;
	private double salary;
	private Date hireDay;
	private Account savingAcct;
    private Account checkingAcct;
    private Account retirementAcct;

	// constructor
	Employee(String name, String aNickName, double aSalary, int aYear,
			int aMonth, int aDay) {
		this.name = name;
		nickName = aNickName;
		salary = aSalary;
		GregorianCalendar cal = new GregorianCalendar(aYear, aMonth - 1, aDay);
		hireDay = cal.getTime();
	}
	// instance methods
	public String getName() {
		return name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String aNickName) {
		nickName = aNickName;
	}
	public double getSalary() {
		return salary;
	}
	// needs to be improved
	public Date getHireDay() {
		return (Date)hireDay.clone();
	}
	public void raiseSalary(double byPercent) {
		double raise = salary * byPercent / 100;
		salary += raise;
	}
	private String format = "name = %s, salary = %.2f, hireDay = %s";
	
	public String toString() {
		return String.format(format, name, salary, Util.dateAsString(hireDay));
	}
	
	
	
	//ForProg2
	public void createNewChecking(double startAmount) {
		 checkingAcct = new Account(AccountType.CHECKING, startAmount);
		
	}

	public void createNewSavings(double startAmount) {
		savingAcct = new Account(AccountType.SAVINGS, startAmount);
		
	}

	public void createNewRetirement(double startAmount) {
		retirementAcct = new Account(AccountType.RETIREMENT, startAmount);		
	}

	public String getFormattedAcctInfo() {
        StringBuilder result = new StringBuilder();
        result.append("ACCOUNT INFO FOR " + this.name + "\n\n");
        result.append(checkingAcct.getFormattedAcctInfo());
        result.append(savingAcct.getFormattedAcctInfo());
        result.append(retirementAcct.getFormattedAcctInfo());
        return result.toString();
    }
	
	public void deposit(String acctType, double amt){
		
		if(acctType.equals("CHECKING"))
            this.checkingAcct.makeDeposit(amt);
            
        if(acctType.equals("SAVINGS"))
            this.savingAcct.makeDeposit(amt);
            
        if(acctType.equals("RETIREMENT"))
            this.retirementAcct.makeDeposit(amt);
            
    
	}
	public boolean withdraw(String acctType, double amt){
		boolean isSuccess = false;
        
        if(acctType.equals("CHECKING"))
                isSuccess = this.checkingAcct.makeWithdrawal(amt);
                
        if(acctType.equals("SAVINGS"))
                isSuccess = this.savingAcct.makeWithdrawal(amt);
                
        if(acctType.equals("RETIREMENT"))
                isSuccess = this.retirementAcct.makeWithdrawal(amt);
                
        
        return isSuccess;
	}
}

