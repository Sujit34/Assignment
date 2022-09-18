package Lab3;

public class Prog1 {
	public static void main(String[] args)
	{
		Employee employee = new Employee("Sujit Kumar", "Chanda", 5000, 2022, 9, 7);
		Account account1 = new Account(employee, AccountType.CHECKING, 300);
		Account account2 = new Account(employee, AccountType.SAVINGS, 300);
		Account account3 = new Account(employee, AccountType.RETIREMENT, 300);
		
		Account account[]= new Account[3];
		account[0] = account1;
		account[1] = account2;
		account[2] = account3;
		
		for(int i=0;i<account.length;i++)
		{
			System.out.println(account[i].toString());
		}
		
		
		
	}

}
