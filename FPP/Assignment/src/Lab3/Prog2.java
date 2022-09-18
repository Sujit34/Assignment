package Lab3;
import java.util.Scanner; 

public class Prog2 {
	
	public static void main(String[] args) {
	    Employee[] emps = null;
		emps = new Employee[3];
		emps[0] = new Employee("Sujit Kumar", "Chanda", 5000, 2022, 9, 7);
		emps[1] = new Employee("Bob", "DCosta", 5000, 2022, 9, 7);
		emps[2] = new Employee("Tom", "DSuja", 5000, 2022, 9, 7);
		
		emps[0].createNewChecking(10500);
		emps[0].createNewSavings(1000);
		emps[0].createNewRetirement(9300);
		emps[1].createNewChecking(34000);
		emps[1].createNewSavings(27000);
		emps[1].createNewRetirement(9000);
		emps[2].createNewChecking(10038);
		emps[2].createNewSavings(12600);
		emps[2].createNewRetirement(9000);	
		
				
		Scanner sc = new Scanner(System.in);
		System.out.print("See a report of all account balances? (y/n) ");
		String answer = sc.next();
		if(answer.equalsIgnoreCase("y")){
			String info = getFormattedAccountInfo(emps);
			System.out.println(info);	
		}
		else {
			//do nothing..the application ends here
		}
		sc.close();
	}
	
	public static String getFormattedAccountInfo(Employee[] emps){		
		String info = ""; 
		for(int i=0;i<emps.length;i++)
		{			
			info += "\n\n"+emps[i].getFormattedAcctInfo();			
			
		}
		return info;
	}
}
