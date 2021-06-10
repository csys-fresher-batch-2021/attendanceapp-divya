/**
 * 
 */
package in.divya.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import in.divya.exceptions.InValidStandardFormatException;

/**
 * @author divy2624
 *
 */
public class StandardValidator {
	private StandardValidator() {
		// Default Constructor
	}

	/**
	 * This method is to check student standard format.
	 * 
	 * @param studentStandard
	 * @param errorMessage
	 * @return
	 * @throws InValidStandardFormatException
	 */

	public static boolean isValidStandardValidation(String studentStandard, String errorMessage)
			throws InValidStandardFormatException {
		boolean isValidFormat = false;
		if (studentStandard != null) {
			String regex = "^(I|II|III|IV|V|VI|VII|VIII|IX|X|XI|XII)$";

			Pattern regexPattern = Pattern.compile(regex);
			Matcher matchCheck = regexPattern.matcher(studentStandard);
			isValidFormat = matchCheck.matches();
			if (isValidFormat) {
				return isValidFormat;
			}
			throw new InValidStandardFormatException(errorMessage);
		}
		return isValidFormat;
	}

}
