/**
 * 
 */
package in.divya.service;

import java.util.List;
import java.util.Map;

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

	/**
	 * To update all student attendance.
	 * 
	 * @param attendanceList
	 * @return
	 * @throws CannotAddAttendanceException
	 */

	public boolean modifyAttendance(List<AttendanceDetails> attendanceList) throws CannotAddAttendanceException {
		AttendanceDAO attendanceDAO = new AttendanceDAO();
		boolean isAddedAttendance = true;
		try {
			for (AttendanceDetails attendance : attendanceList) {
				attendanceDAO.updateAttendance(attendance);
			}
			return isAddedAttendance;
		} catch (Exception e) {
			throw new CannotAddAttendanceException("ATTENDANCE RECORD NOT FOUND");
		}
	}

	/**
	 * Display student attendance.
	 * 
	 * @param studentRollNumber
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<AttendanceDetails> studentAttendance(String studentRollNumber) throws ClassNotFoundException {
		AttendanceDAO attendanceDAO = new AttendanceDAO();
		return attendanceDAO.findStudentAttendance(studentRollNumber);

	}

	/**
	 * To display the count of attendance type.
	 * 
	 * @param studentRollNumber
	 * @return
	 * @throws ClassNotFoundException
	 */
	public Map<String, Integer> attendanceTypeCount(String studentRollNumber) throws ClassNotFoundException {
		AttendanceDAO attendanceDAO = new AttendanceDAO();
		return attendanceDAO.findAttendanceTypeCount(studentRollNumber);

	}

	/**
	 * To display the count of attendance.
	 * 
	 * @param studentRollNumber
	 * @return
	 * @throws ClassNotFoundException
	 */
	public int attendanceCount(String studentRollNumber) throws ClassNotFoundException {
		AttendanceDAO attendanceDAO = new AttendanceDAO();
		return attendanceDAO.findAttendanceCount(studentRollNumber);

	}

}
