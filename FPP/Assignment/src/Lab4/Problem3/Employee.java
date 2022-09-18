package Lab4.Problem3;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
	// instance fields
	private String name;
	private String nickName;
	private double salary;
	private Date hireDay;
	private AccountList accounts;

	// constructor
	Employee(String name, String aNickName, double aSalary, int aYear,
			int aMonth, int aDay) {
		this.name = name;
		nickName = aNickName;
		salary = aSalary;
		GregorianCalendar cal = new GregorianCalendar(aYear, aMonth - 1, aDay);
		hireDay = cal.getTime();
	}
	
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
	
	
	
	
	public void createNewChecking(double startAmount) {
		Account acc = new Account(AccountType.CHECKING, startAmount);
		accounts.add(acc);
		
	}

	public void createNewSavings(double startAmount) {
		Account acc = new Account(AccountType.SAVINGS, startAmount);
		accounts.add(acc);
		
	}

	public void createNewRetirement(double startAmount) {
		Account acc = new Account(AccountType.RETIREMENT, startAmount);	
		accounts.add(acc);
	}

	public String getFormattedAcctInfo() {
		
        StringBuilder result = new StringBuilder();
        result.append("ACCOUNT INFO FOR " + this.name + "\n\n");       
        
        int accSize = accounts.size();
        
        for(int i=0;i<accSize;i++)
        {
        	result.append(accounts.get(0).getFormattedAcctInfo());
        }
        return result.toString();
    }
	
	public void deposit(int accountIndex, double amt){		
		Account selected = accounts.get(accountIndex);
		selected.makeDeposit(amt);         
	}
	
	public boolean withdraw(int accountIndex, double amt){
		boolean isSuccess = false;
        
		Account selected = accounts.get(accountIndex);
		isSuccess = selected.makeWithdrawal(amt);        
                       
        return isSuccess;
	}
}
