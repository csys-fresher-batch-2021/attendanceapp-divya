/**
 * 
 */
package in.divya.service;

import java.util.List;

import in.divya.dao.AttendanceDAO;
import in.divya.exceptions.CannotAddAttendanceException;
import in.divya.model.AttendanceDetails;

/**
 * @author divy2624
 *
 */
public class AttendanceService {

	public AttendanceService() {
		// Default Constructor
	}

	/**
	 * To mark all student attendance.
	 * 
	 * @param attendanceList
	 * @return
	 * @throws CannotAddAttendanceException
	 */

	public boolean addAttendance(List<AttendanceDetails> attendanceList) throws CannotAddAttendanceException {
		AttendanceDAO attendanceDAO = new AttendanceDAO();
		boolean isAddedAttendance = true;
		try {
			for (AttendanceDetails attendance : attendanceList) {
				attendanceDAO.saveAttendance(attendance);
			}
			return isAddedAttendance;
		} catch (Exception e) {
			throw new CannotAddAttendanceException("ALREADY MARKED");
		}
	}

}