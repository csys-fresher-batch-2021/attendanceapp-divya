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

			String sql = "select attendance_date,attendance from attendance where student_roll_number=? order by attendance_date desc";

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
	 * Display Attendance Type Count.
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

			String sql = "select attendance, count(attendance) as count from attendance where student_roll_number=? group by attendance";

			pst = connection.prepareStatement(sql);
			pst.setObject(1, studentRollNumber);
			rs = pst.executeQuery();

			while (rs.next()) {
				String status = rs.getString("attendance");
				Integer count = rs.getInt("count");
				attendanceTypeCount.put(status, count);

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

			String sql = "select count(student_roll_number) from attendance where student_roll_number=?";

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

	/**
	 * All Attendance Display.
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<AttendanceDetails> findAllAttendance() throws ClassNotFoundException {
		List<AttendanceDetails> allAttendanceData = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			connection = ConnectionUtil.getConnection();
			String sql = "select attendance_date,student_roll_number,attendance from attendance order by attendance_date desc";
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				AttendanceDetails attendance = new AttendanceDetails();

				LocalDate attendanceDate = LocalDate.parse(rs.getString("attendance_date"));
				String studentRollNumber = rs.getString("student_roll_number");
				String attendanceType = rs.getString("attendance");
				attendance.setDate(attendanceDate);
				attendance.setStudentRollNumber(studentRollNumber);
				attendance.setAttendance(attendanceType);
				allAttendanceData.add(attendance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return allAttendanceData;
	}

	/**
	 * To display day attendance.
	 * 
	 * @param date
	 * @return
	 * @throws ClassNotFoundException
	 */
	public List<AttendanceDetails> findAttendanceByDate(LocalDate date) throws ClassNotFoundException {
		List<AttendanceDetails> dateAttendance = new ArrayList<>();

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {

			connection = ConnectionUtil.getConnection();

			String sql = "select student_roll_number,attendance_date,attendance from attendance where attendance_date=? order by student_roll_number asc";

			pst = connection.prepareStatement(sql);
			pst.setObject(1, date);
			rs = pst.executeQuery();

			while (rs.next()) {
				AttendanceDetails allAttendance = new AttendanceDetails();

				String studentRollNumber = rs.getString("student_roll_number");
				LocalDate attendanceDate = LocalDate.parse(rs.getString("attendance_date"));
				String attendanceStatus = rs.getString("attendance");
				allAttendance.setStudentRollNumber(studentRollNumber);
				allAttendance.setDate(attendanceDate);
				allAttendance.setAttendance(attendanceStatus);

				dateAttendance.add(allAttendance);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return dateAttendance;

	}

	/**
	 * To display day attendance type count.
	 * 
	 * @param date
	 * @return
	 * @throws ClassNotFoundException
	 */
	public Map<String, Integer> findTypeCountByDate(LocalDate date) throws ClassNotFoundException {
		Map<String, Integer> attendanceCount = new HashMap<>();

		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select attendance, count(attendance) as count from attendance where attendance_date=? group by attendance";
			pst = connection.prepareStatement(sql);
			pst.setObject(1, date);
			rs = pst.executeQuery();
			while (rs.next()) {
				String status = rs.getString("attendance");
				Integer count = rs.getInt("count");
				attendanceCount.put(status, count);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return attendanceCount;

	}

	/**
	 * To display count the number of students from day attendance.
	 * 
	 * @param date
	 * @return
	 * @throws ClassNotFoundException
	 */
	public int findStudentCount(LocalDate date) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select count(attendance_date) from attendance where attendance_date=?";
			pst = connection.prepareStatement(sql);
			pst.setObject(1, date);
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

	/**
	 * To calculate present percentage
	 * 
	 * @param studentRollNumber
	 * @return
	 * @throws ClassNotFoundException
	 */
	public double findPresentPercentageById(String studentRollNumber) throws ClassNotFoundException {
		Connection connection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		double percentage = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select  (Count(attendance)* 100 / (Select Count(student_roll_number) From attendance where student_roll_number=?)) as percentage from attendance where attendance=? and student_roll_number=?";
			pst = connection.prepareStatement(sql);
			pst.setString(1, studentRollNumber);
			pst.setString(2, "PRESENT");
			pst.setString(3, studentRollNumber);
			rs = pst.executeQuery();
			rs.next();
			percentage = Double.parseDouble(rs.getString("percentage"));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(rs, pst, connection);
		}
		return percentage;
	}
}
