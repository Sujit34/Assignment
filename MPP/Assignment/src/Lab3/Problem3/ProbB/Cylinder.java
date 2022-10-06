package Lab3.Problem3.ProbB;


public class Cylinder {
	
	protected double height;
	protected double radius;
	
	Cylinder(double height, double radius){		
		this.height = height;		
		this.radius = radius;
	}
	
	Cylinder( double radius){		
		this.height = 1.0;		
		this.radius = radius;
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public double computeVolume() {
		return Math.PI * this.radius * this.radius * height;
	}

}
