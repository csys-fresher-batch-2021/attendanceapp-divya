/**
 * 
 */
package in.divya.model;

/**
 * @author divy2624
 *
 */
public class FacultyDetails {

	/**
	 * To declare the facultyDetails.
	 */
	private String facultyName;
	private String facultyClass;
	private String facultyEmailId;
	private String facultyPassword;
	private Long facultyMobileNumber;

	/**
	 * @return the facultyName
	 */
	public String getFacultyName() {
		return facultyName;
	}

	/**
	 * @param facultyName the facultyName to set
	 */
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	/**
	 * @return the facultyClass
	 */
	public String getFacultyClass() {
		return facultyClass;
	}

	/**
	 * @param facultyClass the facultyClass to set
	 */
	public void setFacultyClass(String facultyClass) {
		this.facultyClass = facultyClass;
	}

	/**
	 * @return the facultyEmailId
	 */
	public String getFacultyEmailId() {
		return facultyEmailId;
	}

	/**
	 * @param facultyEmailId the facultyEmailId to set
	 */
	public void setFacultyEmailId(String facultyEmailId) {
		this.facultyEmailId = facultyEmailId;
	}

	/**
	 * @return the facultyPassword
	 */
	public String getFacultyPassword() {
		return facultyPassword;
	}

	/**
	 * @param facultyPassword the facultyPassword to set
	 */
	public void setFacultyPassword(String facultyPassword) {
		this.facultyPassword = facultyPassword;
	}

	/**
	 * @return the facultyMobileNumber
	 */
	public Long getFacultyMobileNumber() {
		return facultyMobileNumber;
	}

	/**
	 * @param facultyMobileNumber the facultyMobileNumber to set
	 */
	public void setFacultyMobileNumber(Long facultyMobileNumber) {
		this.facultyMobileNumber = facultyMobileNumber;
	}

	@Override
	public String toString() {
		return "FacultyDetails [facultyName=" + facultyName + ", facultyClass=" + facultyClass + ", facultyEmailId="
				+ facultyEmailId + ", facultyPassword=" + facultyPassword + ", facultyMobileNumber="
				+ facultyMobileNumber + "]";
	}
}
