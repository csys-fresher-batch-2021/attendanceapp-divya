/**
 * 
 */
package in.divya.util;

import static org.junit.Assert.*;


import org.junit.Test;

import in.divya.exceptions.InValidEmailException;

/**
 * @author divy2624
 *
 */
public class EmailValidatorUtilTest {

	/**
	 * To check Valid EmailId Format TestCase.
	 * 
	 * @throws InValidEmailIDException
	 */

	@Test
	public void validEmailIdIsTested() throws InValidEmailException {
		String emailId = "divyamar@gmail.com";
		boolean isValidMail = EmailValidatorUtil.isValidEmailId(emailId, "InValid EmailId Format");
		assertTrue(isValidMail);
	}

	/**
	 * To check InValid EmailId Format TestCase.
	 */

	@Test
	public void inValidEmailIdIsTested() {
		try {
			String emailId = "divyagmail.com";
			boolean isValidMail = EmailValidatorUtil.isValidEmailId(emailId, "InValid EmailID Format");
			assertFalse(isValidMail);
		} catch (Exception e) {
			assertEquals("InValid EmailID Format", e.getMessage());

		}
	}


}
