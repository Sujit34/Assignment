package Lab12.Problem2;

public class OverdrawnAccountException extends Exception {

	
	public OverdrawnAccountException() {
		super();		
	}
	
	public OverdrawnAccountException(Throwable t) {
		super(t);		
	}

	public OverdrawnAccountException(String message) {
		super(message);		
	}

}