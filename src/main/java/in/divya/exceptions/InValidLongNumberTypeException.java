/**
 * 
 */
package in.divya.exceptions;

/**
 * @author divy2624
 *
 */
public class InValidLongNumberTypeException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * @param errorMessage
	 * 
	 */

	public InValidLongNumberTypeException(String errorMessage) {
		super(errorMessage);
	}
}
