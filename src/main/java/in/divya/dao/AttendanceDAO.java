/**
 * 
 */
package in.divya.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	/**
	 * Display student Attendance.
	 * 
	 * @param date
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<AttendanceDetails> findStudentAttendance(String studentRollNumber) throws ClassNotFoundException {
		List<AttendanceDetails> studentAttendanceData = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select * from attendance where student_roll_number=? order by student_roll_number asc";

			pst = connection.prepareStatement(sql);
			pst.setString(1, studentRollNumber);
			rs = pst.executeQuery();

			while (rs.next()) {
				AttendanceDetails attendance = new AttendanceDetails();

				LocalDate attendanceDate = LocalDate.parse(rs.getString("attendance_date"));
				String attendanceType = rs.getString("attendance");
				attendance.setDate(attendanceDate);
				attendance.setAttendance(attendanceType);
				studentAttendanceData.add(attendance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return studentAttendanceData;
	}

	/**
	 * Display Attendance Status Count.
	 * 
	 * @param studentRollNumber
	 * @return
	 * @throws ClassNotFoundException
	 */
	public Map<String, Integer> findAttendanceTypeCount(String studentRollNumber) throws ClassNotFoundException {
		Map<String, Integer> attendanceTypeCount = new HashMap<>();

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select attendance, count(*) as cnt from attendance where student_roll_number=? group by attendance";

			pst = connection.prepareStatement(sql);
			pst.setObject(1, studentRollNumber);
			rs = pst.executeQuery();

			while (rs.next()) {
				String status = rs.getString("attendance");
				Integer cnt = rs.getInt("cnt");
				attendanceTypeCount.put(status, cnt);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return attendanceTypeCount;

	}

	/**
	 * Display Number Of Counts.
	 * 
	 * @param studentRollNumber
	 * @return
	 * @throws ClassNotFoundException
	 */
	public int findAttendanceCount(String studentRollNumber) throws ClassNotFoundException {

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count = 0;
		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select count(*) from attendance where student_roll_number=?";

			pst = connection.prepareStatement(sql);
			pst.setObject(1, studentRollNumber);
			rs = pst.executeQuery();
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return count;
	}

}
