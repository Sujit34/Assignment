package Lab5.Problem3;

import java.util.*;

public class Main {
	public static void main(String[] args) {		
		
		List<Shape> shapes = new ArrayList<Shape>();
		
		shapes.add(new Circle(5.0));
		shapes.add(new Rectangle(4.5, 3.5));
		shapes.add(new Triangle(5.0, 4.0));
		
		double sum = 0.0;	
		
		for (Shape shape : shapes) {
			sum += shape.computeArea();
		}
		
		System.out.printf("Sum of Areas = %.2f", sum);
	}
}
