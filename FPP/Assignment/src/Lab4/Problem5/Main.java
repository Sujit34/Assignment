package Lab4.Problem5;

public class Main {
	public static void main(String[] args) {

		Polygon[] objects = {	 new Rectangle(3,4),
								 new Triangle(4,5,6),
								 new Square(3)
								 
								 };
		
		for(Polygon cc : objects) {
			System.out.println("For this "+cc.getClass().getSimpleName()+ "\n "+								
								" Perimeter = "+cc.computePerimeter()+ "\n "
					);			
		}    
	}

}
