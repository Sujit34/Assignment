package Lab8.Problem1.PartB;

import java.util.function.Supplier;

public class iii {
	public static void main(String[] args) {
		iii main = new iii();
		InnerClass inner = main.new InnerClass();
		System.out.println(inner.get());
	}
	
	class InnerClass implements Supplier {
		@Override
		public Object get() {
			return Math.random();
		}

	}
}

