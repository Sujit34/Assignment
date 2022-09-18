package Lab2;

public class Prog2 {
	
	public static void main(String[] args) {
		 final double Pi = 3.1415926536;			
		 System.out.println("First computation is : " +Computation1(Pi));
		 System.out.println("Second computation is : " +Computation2(Pi));
		}
	
	public static double Computation1(double Pi)
	{
		double x = RandomNumbers.getRandomInt(1, 9);		
		return Math.pow(Pi,x);
	}
	
	public static double Computation2(double Pi)
	{
		double y = RandomNumbers.getRandomInt(3, 14);
		return Math.pow(y, Pi);
	}
	
	
	
}
