/**
 * 
 */
package in.divya.util;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import in.divya.exceptions.InValidEmailException;

/**
 * @author divy2624
 *
 */
public class EmailValidatorUtil {

	private EmailValidatorUtil() {
		// Default Constructor
	}

	/**
	 * This method verifies whether the emailId is in valid format or not
	 * 
	 * @param emailId
	 * @param errorMessage
	 * @return
	 * @throws InValidEmailIDException
	 */

	public static boolean isValidEmailId(String emailId, String errorMessage) throws InValidEmailException {
		boolean isValidFormat = false;
		if (emailId == null || emailId.isEmpty()) {
			throw new InValidEmailException(errorMessage);
		} else {
			String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";

			/**
			 * ^ matches the starting of the sentence.
			 * 
			 * [a-zA-Z0-9+_.-] matches one character from the English alphabet (both cases),
			 * digits, “+”, “_”, “.” and, “-” before the @ symbol.
			 * 
			 * + indicates the repetition of the above-mentioned set of characters one or
			 * more times.
			 * 
			 * @ matches itself.
			 * 
			 * [a-zA-Z0-9.-] matches one character from the English alphabet (both cases),
			 * digits, “.” and “–” after the @ symbol.
			 * 
			 * $ indicates the end of the sentence
			 */

			Pattern regexEmailFormat = Pattern.compile(regex);
			Matcher matchEmailPattern = regexEmailFormat.matcher(emailId);
			isValidFormat = matchEmailPattern.matches();
			if (isValidFormat) {
				return isValidFormat;
			}
			throw new InValidEmailException(errorMessage);
		}

	}

}
