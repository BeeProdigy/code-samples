package assignment16;

public class TooSmallNumberException extends Exception {
	public String message;
	public TooSmallNumberException(int numb){
		super((double) numb + " is too small for factorial!");
	}
}
