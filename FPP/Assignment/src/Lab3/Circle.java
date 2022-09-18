package Lab3;

public final class Circle {
	
	private double radius;
	private final double Pi = 3.1415926536; 
	
	Circle(double rd){
		this.radius = rd;		
	}
	
	public double getRadius(){
		 return this.radius;
	} 
	
	public double computeArea() {
		return  this.Pi * this.radius * this.radius;
	}
}
