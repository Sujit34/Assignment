package Lab3;

public final class Rectangle {
	
	private double width;
	private double length;
	
	Rectangle(double wd, double len){
		this.width = wd;
		this.length = len;
	}
	
	public double getWidth() {
		 return this.width;
	} 
	
	public double getLength() {
		 return this.length;
	 } 
	
	public double computeArea() {
		return  this.width * this.length;
	}

}
