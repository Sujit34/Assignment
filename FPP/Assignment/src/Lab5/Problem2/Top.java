package Lab5.Problem2;

public class Top {
	int t = 1;
	Middle mid;
	Middle.Bottom midbot;
	
	Top(){
		mid = new Middle();
		midbot = mid.midbot;
	}
	
	//returns the value in the instance variable of Bottom
	int readBottom() {			
		return midbot.b;
	}
	class Middle {
		int m = 2;
		Middle.Bottom midbot = new Bottom();
		//returns sum of instance variable in Top and 
		//instance variable in Bottom
		int addTopAndBottom() {		
			return t+readBottom();
		}
		class Bottom {
			int b = 3;
			//returns the product of the instance variable
			//in all three classes
			int multiplyAllThree() {				
				return t*m*b;
			}
		}
	}
	public static void main(String[] args){
		Top top = new Top();

		System.out.println(top.readBottom());
		System.out.println(top.mid.addTopAndBottom());
		System.out.println(top.midbot.multiplyAllThree());

	}

}
