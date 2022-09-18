package Lab3;

public class Prog4 {

	public static void main(String[] args) {
		
		Triangle tr = new Triangle(4,4);
		System.out.println("Area of Triangle is : "+ tr.computeArea());
		
		Triangle triangle = new Triangle(2,3,4);
		System.out.println("Area of Triangle is : "+ triangle.computeArea());
		
		Rectangle rac = new Rectangle(4,4);
		System.out.println("Area of Rectangle is : "+ rac.computeArea());
		
		Circle cc = new Circle(4);
		System.out.println("Area of Circle is : "+ cc.computeArea());
	}
}
