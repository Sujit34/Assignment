package Lab4.Problem4;

public class Main {
	public static void main(String[] args) {

		Polygon[] objects = {	 new Square(3),
								 new Triangle(4,5,6),
								 new Rectangle(3,4)
								 };
		
		for(Polygon cc : objects) {
			System.out.println("For this "+cc.getClass().getSimpleName()+ "\n "+ 
								" Number of sides = "+cc.getNumberOfSides()+ "\n "+
								" Perimeter = "+cc.computePerimeter()+ "\n "
					);			
		}    
	}

}
