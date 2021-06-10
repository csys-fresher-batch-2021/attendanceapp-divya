/**
 * 
 */
package in.divya.exceptions;

/**
 * @author divy2624
 *
 */
public class CannotRegisterStudentException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param errorMessage
	 */

	public CannotRegisterStudentException(String errorMessage) {
		super(errorMessage);
	}

}
