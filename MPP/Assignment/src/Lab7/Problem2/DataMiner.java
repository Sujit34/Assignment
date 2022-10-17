package Lab7.Problem2;

import java.util.*;

public class DataMiner {
	List<ClosedCurve> objects = new ArrayList<>();
	public static void main(String[] args) {
		DataMiner dm = new DataMiner();
		dm.objects.add(new Rectangle(5,7));
		dm.objects.add(new EquilateralTriangle(7));
		dm.objects.add(new Circle(6));
		dm.objects.add(new Ellipse(3,3));		
		System.out.println("Sum of different type of Polygon and ClosedCurve is: " +dm.computeAveragePerimeter());
	}
	
	//OO (good) way of performing computation
	public double computeAveragePerimeter() {
		if(objects == null || objects.isEmpty()) return 0.0;
		double sum = 0.0;
		for(int i = 0; i < objects.size(); ++i) {
			System.out.println("Perimeter of " + objects.get(i).getClass().getSimpleName() +" is : " + objects.get(i).computePerimeter() );
			sum += objects.get(i).computePerimeter();
		}
		
		return sum/objects.size();
	}

}
