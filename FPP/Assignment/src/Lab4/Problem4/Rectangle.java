package Lab4.Problem4;

public final class Rectangle implements Polygon{
	private final double width;
	private final double length;
	
	public Rectangle(double width,double length) {
		this.width = width;
		this.length = length;
	}
	 
	public int getNumberOfSides(){ 
	      return 4;
	}
	
	public double computePerimeter() {
		return 2*(this.width+this.length);
	}

}
