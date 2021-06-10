/**
 * 
 */
package in.divya.util;

import static org.junit.Assert.*;

import org.junit.Test;

import in.divya.exceptions.InValidPasswordException;

/**
 * @author divy2624
 *
 */
public class PasswordValidatorUtilTest {

	/**
	 * To check valid password format testcase.
	 * 
	 * @throws InValidPasswordException
	 */

	@Test
	public void validPasswordFormatIsTested() throws InValidPasswordException {
		String password = "Divya@76";
		boolean isValidPassword = PasswordValidatorUtil.isValidPasswordFormat(password, "Invalid password format");
		assertTrue(isValidPassword);
	}

	/**
	 * To check invalid password format testcase.
	 */

	@Test
	public void inValidPasswordFormatIsTested() {
		try {
			String password = "raja123";
			boolean isValidPassword = PasswordValidatorUtil.isValidPasswordFormat(password, "Invalid password format");
			assertFalse(isValidPassword);
		} catch (Exception e) {
			assertEquals("Invalid password format", e.getMessage());
		}
	}
}
