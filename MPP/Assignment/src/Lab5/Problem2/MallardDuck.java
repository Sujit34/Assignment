package Lab5.Problem2;

public class MallardDuck extends Duck{
	@Override
	public void display() {
		System.out.println("  display");
	}

	@Override
	protected FlyBehavior createFlyInstance() {
		return new FlyWithWings();
	}

	@Override
	protected QuackBehavior createQuackBehavior() {
		return new Quack();	
	}

}
