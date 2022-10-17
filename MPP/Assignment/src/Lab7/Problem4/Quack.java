package Lab7.Problem4;

public interface Quack {
	default void quack() {
		System.out.println("  quacking");
	}
}
