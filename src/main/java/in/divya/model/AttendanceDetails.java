/**
 * 
 */
package in.divya.model;

import java.time.LocalDate;

/**
 * @author divy2624
 *
 */
public class AttendanceDetails {

	private LocalDate date;
	private String studentRollNumber;
	private String attendance;

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the studentRollNumber
	 */
	public String getStudentRollNumber() {
		return studentRollNumber;
	}

	/**
	 * @param studentRollNumber the studentRollNumber to set
	 */
	public void setStudentRollNumber(String studentRollNumber) {
		this.studentRollNumber = studentRollNumber;
	}

	/**
	 * @return the attendance
	 */
	public String getAttendance() {
		return attendance;
	}

	/**
	 * @param attendance the attendance to set
	 */
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}

	@Override
	public String toString() {
		return "AttendanceDetails [date=" + date + ", studentRollNumber=" + studentRollNumber + ", attendance="
				+ attendance + "]";
	}

}
