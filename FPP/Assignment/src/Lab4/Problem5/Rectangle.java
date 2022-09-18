package Lab4.Problem5;


public final class Rectangle implements Polygon{
	private final double width;
	private final double length;
	
	public Rectangle(double width,double length) {
		this.width = width;
		this.length = length;
	}
	
	public double[] getArrayOfSides()
	{
		double [] sides = new double[5];
		sides[0] = this.width;
		sides[1] = this.length;
		sides[2] = this.width;
		sides[3] = this.length;
		return sides;
	}

}
