/**
 * 
 */
package in.divya.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author divy2624
 *
 */
public class StringValidatorUtilTest {

	@Test
	public void emptyStringInputIsChecked() {
		try {
			StringValidatorUtil.isStringNotNullOrEmpty(" ", "Field cannot be Empty");
		} catch (Exception e) {
			assertEquals("Field cannot be Empty", e.getMessage());
		}

	}

	/**
	 * To check valid string testcase
	 */

	@Test
	public void validStringInputIsChecked() {
		try {
			boolean isValidString = StringValidatorUtil.isStringNotNullOrEmpty("K.DIVYA", "Field cannot be Empty");
			assertTrue(isValidString);
		} catch (Exception e) {
			assertEquals("Field cannot be Empty", e.getMessage());
		}

	}

	/**
	 * To check null testcase
	 */

	@Test
	public void nullStringInputIsChecked() {
		try {
			StringValidatorUtil.isStringNotNullOrEmpty(null, "Field cannot be Empty");
		} catch (Exception e) {
			assertEquals("Field cannot be Empty", e.getMessage());
		}

	}

}
