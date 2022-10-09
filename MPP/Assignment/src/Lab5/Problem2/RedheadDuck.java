package Lab5.Problem2;

public class RedheadDuck extends Duck {
	@Override
	public void display() {
		System.out.println("  displaying");
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
