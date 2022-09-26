package Lab12.Problem1;

public final class Circle extends ClosedCurve {
	private final double radius;
	public Circle(double radius) throws IllegalClosedCurveException {
		this.radius = radius;
		
		if(this.radius < 0)
			throw new IllegalClosedCurveException("The radius is not valid");
	}
	public double computeArea() {
		return (Math.PI * radius * radius);
	}
}
