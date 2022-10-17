package Lab7.Problem4;

public interface MuteQuack extends Quack{
	default void quack() {
		System.out.println("  cannot quack");
	}
}
