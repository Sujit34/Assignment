package Lab2;

import java.util.Scanner; 
public class Prog5 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);  
	    System.out.println("Enter input");

	    String input = sc.nextLine();
	    
	    for(int i=input.length()-1;i>=0;i--)
	    {
	    	System.out.print(input.charAt(i));
	    }
	    System.out.println();
		}

}
