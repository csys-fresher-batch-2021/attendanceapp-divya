/**
 * 
 */
package in.divya.validator;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import in.divya.exceptions.InValidRollNumberException;

/**
 * @author divy2624
 *
 */
public class RollNumberValidator {

	private RollNumberValidator() {
		// Default Constructor
	}

	/**
	 * This method to check roll number format is valid or not.
	 * 
	 * @param studentRollNumber
	 * @param errorMessage
	 * @return
	 * @throws InValidRollNumberException
	 */

	public static boolean isValidRollNumberFormat(String studentRollNumber, String errorMessage)
			throws InValidRollNumberException {
		boolean isValidFormat = false;
		if (studentRollNumber != null) {
			String regex = "^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$";

			/**
			 * ^ means start of string [A-Z]{2} means 2 characters in the range of A through
			 * Z [0-9]{2} means 2 characters in the range of 0 through 9 [A-Z]{2} means 2
			 * characters in the range of A through Z [0-9]{4} means 4 characters in the
			 * range of 0 through 9 $ means end of string
			 */
			Pattern regexPattern = Pattern.compile(regex);
			Matcher matchCheck = regexPattern.matcher(studentRollNumber);
			isValidFormat = matchCheck.matches();
			if (isValidFormat) {
				return isValidFormat;
			}
			throw new InValidRollNumberException(errorMessage);
		}
		return isValidFormat;
	}

}
