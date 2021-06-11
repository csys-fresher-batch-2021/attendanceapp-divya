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

	/**
	 * To update student Attendance in database.
	 * 
	 * @param attendance
	 * @throws ClassNotFoundException
	 * @throws CannotAddAttendanceException
	 */
	public void updateAttendance(AttendanceDetails attendance)
			throws ClassNotFoundException, CannotAddAttendanceException {
		PreparedStatement pst = null;
		Connection connection = null;
		int rs = 0;

		try {
			connection = ConnectionUtil.getConnection();
			String sql = "update attendance set attendance=? where attendance_date=? and student_roll_number=?";

			pst = connection.prepareStatement(sql);
			pst.setString(1, attendance.getAttendance());
			pst.setObject(2, attendance.getDate());
			pst.setString(3, attendance.getStudentRollNumber());
			pst.executeUpdate();

			rs = pst.executeUpdate();
			if (rs == 0) {
				throw new CannotAddAttendanceException("ATTENDANCE RECORD NOT FOUND");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(pst, connection);
		}

	}

}
