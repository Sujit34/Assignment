package Lab4.Problem2;


public final class Rectangle extends ClosedCurve {
	private final double width;
	private final double length;
	
	public Rectangle(double width,double length) {
		this.width = width;
		this.length = length;
	}
	public double computeArea() {
		return (width * length);
	}
}