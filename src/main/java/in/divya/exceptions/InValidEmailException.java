/**
 * 
 */
package in.divya.exceptions;

/**
 * @author divy2624
 *
 */
public class InValidEmailException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * @param message
	 */

	public InValidEmailException(String message) {
		super(message);
	}

}
