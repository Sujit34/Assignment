package Lab4.Problem4;

public final class Square implements Polygon {
	private final double side;
	
	public Square(double side){
		this.side = side;
		
	}	
	
	public int getNumberOfSides(){ 
	      return 4;
	}
	
	public double computePerimeter() {
		return this.side*4;
	}
}
