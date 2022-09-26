package Lab12.Problem1;

public final class Square extends ClosedCurve{
	private final double side;
	
	public Square(double side) throws IllegalClosedCurveException{
		this.side = side;
		
		if(this.side < 0)
			throw new IllegalClosedCurveException("The side is not valid");
		
	}
	public double computeArea() {
		return side * side;
	}

}
