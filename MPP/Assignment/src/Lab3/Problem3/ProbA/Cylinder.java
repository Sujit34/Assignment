package Lab3.Problem3.ProbA;

public class Cylinder {
	private double height;
	private double radius;
	
	Cylinder(double height, double radius){
		this.radius = radius;
		this.height = height;		
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double computeVolume() {
		return Math.PI *  radius *  radius * height;
	}

}