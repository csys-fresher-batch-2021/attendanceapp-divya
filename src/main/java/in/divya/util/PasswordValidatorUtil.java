/**
 * 
 */
package in.divya.util;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import in.divya.exceptions.InValidPasswordException;

/**
 * @author divy2624
 *
 */
public class PasswordValidatorUtil {
	private PasswordValidatorUtil() {
		// Default constructor
	}

	/**
	 * This method verifies whether the password is in valid format or not
	 * 
	 * @param errorMessage
	 * @param password
	 * @param errorMessage
	 * @return
	 * @return
	 * @throws InValidPasswordFormatException
	 */

	public static boolean isValidPasswordFormat(String studentPassword, String errorMessage)
			throws InValidPasswordException {
		boolean isValidFormat = false;
		if (studentPassword != null) {
			String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,15}$";
			/**
			 * ^ represents starting character of the string. (?=.*[0-9]) represents a digit
			 * must occur at least once. (?=.*[a-z]) represents a lower case alphabet must
			 * occur at least once. (?=.*[A-Z]) represents an upper case alphabet that must
			 * occur at least once. (?=.*[@#$%^&-+=()] represents a special character that
			 * must occur at least once. (?=\\S+$) white spaces don’t allowed in the entire
			 * string. .{8, 15} represents at least 8 characters and at most 20 characters.
			 * $ represents the end of the string.
			 */
			Pattern regexPattern = Pattern.compile(regex);
			Matcher matchCheck = regexPattern.matcher(studentPassword);
			isValidFormat = matchCheck.matches();
			if (isValidFormat) {
				return isValidFormat;
			}
			throw new InValidPasswordException(errorMessage);
		}
		return isValidFormat;
	}

}
