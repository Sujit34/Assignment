package Lab7.Problem2;

public class Ellipse implements ClosedCurve {
	private double semiMajorAxis;
	private double eccentricity;
	public Ellipse(double sma, double eie) {
		semiMajorAxis = sma;
		eccentricity = eie;
	}
	
	public double getSemiMajorAxis() {
		return semiMajorAxis;
	}
	public double getEccentricity() {
		return eccentricity;
	}
	
	
	@Override
	public double computePerimeter() {
		return 4 * semiMajorAxis * eccentricity;
	}

}

