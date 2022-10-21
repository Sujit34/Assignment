package Lab10.prob3;

@SuppressWarnings("serial")
public class InputTooLongRuntimeException extends RuntimeException {
	public InputTooLongRuntimeException() {
		super();
	}
	public InputTooLongRuntimeException(String msg) {
		super(msg);
	}
	public InputTooLongRuntimeException(Throwable t) {
		super(t);
	}
}
