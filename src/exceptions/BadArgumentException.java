package exceptions;

public class BadArgumentException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Argument doesn't respect preconditions";
	}
	
	

}
