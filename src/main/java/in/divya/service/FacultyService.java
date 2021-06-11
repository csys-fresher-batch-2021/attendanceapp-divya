/**
 * 
 */
package in.divya.service;

import java.util.List;

import in.divya.dao.FacultyDAO;

/**
 * @author divy2624
 *
 */
public class FacultyService {
	public FacultyService() {
		/**
		 * Default constructor
		 */
	}

	/**
	 * To validate faculty login.
	 * 
	 * @param facultyName
	 * @param facultyEmailId
	 * @param facultyPassword
	 * @return
	 * @throws ClassNotFoundException
	 */

	public boolean facultyValidation(String facultyName, String facultyEmailId, String facultyPassword)
			throws ClassNotFoundException {
		FacultyDAO facultyDAO = new FacultyDAO();
		boolean isValidFacultyCredentials = false;
		List<String> facultyCredetials = facultyDAO.findFacultyData();
		/**
		 * If it is true......Login sucessfully. otherwise it is failed
		 */
		if (facultyCredetials.contains(facultyName) && facultyCredetials.contains(facultyEmailId)
				&& facultyCredetials.contains(facultyPassword)) {
			isValidFacultyCredentials = true;
		}
		return isValidFacultyCredentials;

	}

}
