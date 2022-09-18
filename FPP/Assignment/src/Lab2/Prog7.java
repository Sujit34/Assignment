package Lab2;

public class Prog7 {
	public static void main(String[] args){
		String output = "";
		output = String.format("%16d %12d %12d %12d %n %n", RandomNumbers.getRandomInt(1,99), RandomNumbers.getRandomInt(1,99),RandomNumbers.getRandomInt(1,99),RandomNumbers.getRandomInt(1,99));
		output += String.format("%13s %2d %9s %2d %9s %2d %9s %2d %n","+", RandomNumbers.getRandomInt(1,99), "+", RandomNumbers.getRandomInt(1,99),"+",RandomNumbers.getRandomInt(1,99),"+",RandomNumbers.getRandomInt(1,99));
		output += String.format("%16s %12s %12s %12s %n %n %n","____", "____","____","____");
		output += String.format("%16d %12d %12d %12d %n %n", RandomNumbers.getRandomInt(1,99), RandomNumbers.getRandomInt(1,99),RandomNumbers.getRandomInt(1,99),RandomNumbers.getRandomInt(1,99));
		output += String.format("%13s %2d %9s %2d %9s %2d %9s %2d %n","+", RandomNumbers.getRandomInt(1,99), "+", RandomNumbers.getRandomInt(1,99),"+",RandomNumbers.getRandomInt(1,99),"+",RandomNumbers.getRandomInt(1,99));
		output += String.format("%16s %12s %12s %12s %n %n %n","____", "____","____","____");
		
	
		
		System.out.println(output);
	}
}
