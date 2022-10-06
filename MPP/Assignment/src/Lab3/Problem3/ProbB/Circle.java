package Lab3.Problem3.ProbB;

public class Circle {
	
	
	private Cylinder cylinder;
	private double radius;
	
	Circle(double radius){	
		this.cylinder = new Cylinder(radius);
		this.radius = radius;
		
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public double computeArea() {
		return Math.PI * this.radius * this.radius;
	}
}
