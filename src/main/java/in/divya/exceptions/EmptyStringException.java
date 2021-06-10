/**
 * 
 */
package in.divya.exceptions;

/**
 * @author divy2624
 *
 */
public class EmptyStringException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */
	public EmptyStringException(String message) {
		super(message);
	}

}
