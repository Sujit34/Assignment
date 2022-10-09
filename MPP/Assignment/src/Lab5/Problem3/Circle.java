package Lab5.Problem3;

public final class Circle implements Shape {
	
	private double radius;

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}
	
	@Override
	public double computeArea() {
		return Math.PI * this.radius * this.radius;
	}

}
