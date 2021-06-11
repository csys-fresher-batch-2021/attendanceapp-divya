/**
 * 
 */
package in.divya.exceptions;

/**
 * @author divy2624
 *
 */
public class CannotAddAttendanceException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param errorMessage
	 */

	public CannotAddAttendanceException(String errorMessage) {
		super(errorMessage);
	}

}
