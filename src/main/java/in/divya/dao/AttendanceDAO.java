/**
 * 
 */
package in.divya.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.divya.exceptions.CannotAddAttendanceException;
import in.divya.model.AttendanceDetails;
import in.divya.util.ConnectionUtil;

/**
 * @author divy2624
 *
 */
public class AttendanceDAO {

	public AttendanceDAO() {
		// Default Constructor
	}

	/**
	 * To save all student attendance into database.
	 * 
	 * @param attendance
	 * @throws ClassNotFoundException
	 * @throws CannotAddAttendanceException
	 */
	public void saveAttendance(AttendanceDetails attendance)
			throws ClassNotFoundException, CannotAddAttendanceException {
		PreparedStatement pst = null;
		Connection connection = null;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into attendance(attendance_date,student_roll_number,attendance)values(?,?,?)";
			pst = connection.prepareStatement(sql);
			pst.setObject(1, attendance.getDate());
			pst.setString(2, attendance.getStudentRollNumber());
			pst.setString(3, attendance.getAttendance());
			pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new CannotAddAttendanceException("ALREADY EXISTS");
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

}
