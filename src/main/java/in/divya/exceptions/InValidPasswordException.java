/**
 * 
 */
package in.divya.exceptions;

/**
 * @author divy2624
 *
 */
public class InValidPasswordException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */

	public InValidPasswordException(String message) {
		super(message);
	}

}
