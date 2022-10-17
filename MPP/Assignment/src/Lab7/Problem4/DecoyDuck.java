package Lab7.Problem4;

public class DecoyDuck extends Duck implements CannotFly, MuteQuack {
	
	@Override
	public void display() {
		System.out.println("  displaying");
		
	}
}