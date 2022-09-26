package Lab12.Problem1;


public class IllegalTriangleException extends IllegalClosedCurveException {

	public IllegalTriangleException(){
		super();
	}
	
	public IllegalTriangleException(Throwable t) {
		super(t);		
	}
	
	public IllegalTriangleException(String msg) {
		super(msg);
	}

}
