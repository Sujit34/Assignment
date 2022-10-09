package Lab5.Problem3;

public final class Rectangle implements Shape {
	
	private double length;
	private double width;
	
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}	

	public double getLength() {
		return this.length;
	}

	public double getWidth() {
		return this.width;
	}
	
	@Override
	public double computeArea() {
		return this.length * this.width;
	}

}
