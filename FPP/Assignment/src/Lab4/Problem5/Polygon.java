package Lab4.Problem5;

public interface Polygon {
	public double[] getArrayOfSides();
	
	static double sum(double[] arr) {
		double sum=0;
		
		for(double value :arr) {
			sum=sum+value;
		}
		
		return sum;
	}
	
	default double computePerimeter() {
		return sum(getArrayOfSides());
	}

}
