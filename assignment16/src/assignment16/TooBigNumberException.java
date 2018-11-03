package assignment16;

public class TooBigNumberException extends Exception {
	public  TooBigNumberException(int numb){
		super((double) numb + " is too big for recursive calls!");
	}
}
