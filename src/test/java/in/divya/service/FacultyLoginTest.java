/**
 * 
 */
package in.divya.service;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author divy2624
 *
 */
public class FacultyLoginTest {

	static FacultyService facultyService = new FacultyService();

	/**
	 * Both are Valid
	 * 
	 * @throws ClassNotFoundException
	 */

	@Test
	public void isBothValidTestCase() throws ClassNotFoundException {
		String facultyName = "M.LAKSHMI";
		String facultyEmailId = "laksram@gmail.com";
		String facultyPassword = "Rlakshmi@123";
		boolean inValidCredentials = facultyService.facultyValidation(facultyName, facultyEmailId, facultyPassword);
		assertTrue(inValidCredentials);
	}

	/**
	 * InValid name and Valid emailId,password
	 * 
	 * @throws ClassNotFoundException
	 */

	@Test
	public void isNameInValidTestCase() throws ClassNotFoundException {
		String facultyName = "SELVA";
		String facultyEmailId = "laksram@gmail.com";
		String facultyPassword = "Rlakshmi@123";
		boolean inValidCredentials = facultyService.facultyValidation(facultyName, facultyEmailId, facultyPassword);
		assertFalse(inValidCredentials);
	}

	/**
	 * Valid name,emailID and InValid password
	 * 
	 * @throws ClassNotFoundException
	 */

	@Test
	public void isPasswordInValidTestCase() throws ClassNotFoundException {
		String facultyName = "M.LAKSHMI";
		String facultyEmailId = "laksram@gmail.com";
		String facultyPassword = "RLaks@123";
		boolean inValidCredentials = facultyService.facultyValidation(facultyName, facultyEmailId, facultyPassword);
		assertFalse(inValidCredentials);
	}

	/**
	 * Both are InValid
	 * 
	 * @throws ClassNotFoundException
	 */

	@Test
	public void isBothInvalidTestCase() throws ClassNotFoundException {
		String facultyName = "RAMYA";
		String facultyEmailId = "laks@gmail.com";
		String facultyPassword = "Ramya@56";
		boolean inValidCredentials = facultyService.facultyValidation(facultyName, facultyEmailId, facultyPassword);
		assertFalse(inValidCredentials);
	}

}
