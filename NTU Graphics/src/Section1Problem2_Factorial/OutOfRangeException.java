package Section1Problem2_Factorial;

/** This is a custom exception made by me.  */
@SuppressWarnings("serial")
public class OutOfRangeException extends Exception {

	OutOfRangeException() {
	}
	
	OutOfRangeException(String message) {
		super(message);
	}
	
}
