package Lab5.Problem2;

public abstract class Duck {
	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;
	
	public Duck() {
		flyBehavior = createFlyInstance();
		quackBehavior = createQuackBehavior();
	}
	
	protected abstract FlyBehavior createFlyInstance();
	protected abstract QuackBehavior createQuackBehavior();
	
	public void fly() {
		flyBehavior.fly();
	}
	
	public void swim(){ 
		System.out.println("  swimming");
	}
	
	public abstract void display();
	
	public void quack() {
		quackBehavior.quack();
	}
}
