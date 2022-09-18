package Lab4.Problem1;

import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		
		DeptEmployee[] deptEmployees = new DeptEmployee[5];
		
		deptEmployees[0]= new Professor("ABC",5000,2011,06,12,10);
		deptEmployees[1]= new Professor("DEF",6000,2011,06,12,10);
		deptEmployees[2]= new Professor("GHI",7000,2011,06,12,10);
		
		deptEmployees[3]= new Secretary("ABC",5000,2011,06,12,200);
		deptEmployees[4]= new Secretary("DEF",6000,2011,06,12,200);
		
		Scanner sc = new Scanner(System.in);
		System.out.print("See a report of all account balances? (y/n) ");
		String answer = sc.next();
		if(answer.equalsIgnoreCase("y")){
			String info = getTotalSalary(deptEmployees);
			System.out.println(info);	
		}
		else {
			//do nothing..the application ends here
		}
		sc.close();
	}
	
	public static String getTotalSalary(DeptEmployee[] deptEmployees){		
		
		double totalSalary = 0;
		for(int i=0;i<deptEmployees.length;i++)
		{			
			totalSalary = totalSalary + deptEmployees[i].computeSalary();			
			
		}
		return  "Total Salary:" + totalSalary;
	}
}
