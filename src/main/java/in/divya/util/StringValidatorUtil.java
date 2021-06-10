/**
 * 
 */
package in.divya.util;

import in.divya.exceptions.EmptyStringException;

/**
 * @author divy2624
 *
 */
public class StringValidatorUtil {
	private StringValidatorUtil() {
		// Default Constructor
	}

	/**
	 * To check the given string is not null or Empty.
	 * 
	 * @param stringToValidate
	 * @param errorMessage
	 * @return
	 * @throws EmptyStringException
	 */

	public static boolean isStringNotNullOrEmpty(String stringToValidate, String errorMessage)
			throws EmptyStringException {
		if (stringToValidate == null || stringToValidate.trim().isEmpty()) {
			throw new EmptyStringException(errorMessage);
		}
		return true;
	}

}
