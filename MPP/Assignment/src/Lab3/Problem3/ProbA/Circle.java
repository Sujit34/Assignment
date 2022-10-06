package Lab3.Problem3.ProbA;

public class Circle extends Cylinder{
	
	protected double radius;
	
	Circle(double height, double radius){		
		super(height,radius);
		this.radius = radius;
	}
	
	Circle(double radius){		
		super(1.0,radius);
		this.radius = radius;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public double computeArea() {
		return Math.PI * this.radius * this.radius;
	}
}

