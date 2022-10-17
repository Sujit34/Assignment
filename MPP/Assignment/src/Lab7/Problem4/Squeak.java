package Lab7.Problem4;

public interface Squeak extends Quack{
	default void quack() {
		System.out.println("  squeaking");
	}
}
