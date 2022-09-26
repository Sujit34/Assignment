package Lab12.Problem1;

public final class Rectangle extends ClosedCurve {
	private final double width;
	private final double length;
	
	public Rectangle(double width,double length) throws IllegalClosedCurveException {
		this.width = width;
		this.length = length;
		
		if(this.length < 0 || this.width < 0)
			throw new IllegalClosedCurveException("The length or width is not valid");
	}
	public double computeArea() {
		return (width * length);
	}
}
