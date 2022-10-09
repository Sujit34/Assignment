package Lab5.Problem2;

public class RubberDuck extends Duck{
	@Override
	public void display() {
		System.out.println("  displaying");
	}

	@Override
	protected FlyBehavior createFlyInstance() {
		return new CannotFly();
	}

	@Override
	protected QuackBehavior createQuackBehavior() {
		return new Squeak();
	}
}
