package Lab4.Problem5;

public final class Square implements Polygon {
	private final double side;
	
	public Square(double side){
		this.side = side;
		
	}
	public double[] getArrayOfSides()
	{
		double [] sides = new double[5];
		sides[0] = this.side;
		sides[1] = this.side;
		sides[3] = this.side;
		sides[4] = this.side;
		return sides;
	}
	
}
