package in.divya.servlet;

import java.io.IOException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.divya.exceptions.CannotAddAttendanceException;
import in.divya.model.AttendanceDetails;
import in.divya.service.AttendanceService;
import in.divya.util.DateValidatorUtil;

/**
 * Servlet implementation class AttendanceAddServlet
 */
@WebServlet("/AttendanceAddServlet")
public class AttendanceAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AttendanceAddServlet() {
		super();
	}

	/**
	 * To get values from jsp and passing to service.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AttendanceService attendanceService = new AttendanceService();
		try {
			String date = request.getParameter("dateOfAttendance");
			LocalDate attendanceDate = DateValidatorUtil.isDateFormatOrNot(date, "InValid Date Format");
			DateValidatorUtil.isNotAFutureDate(attendanceDate, "Date cannot be a future date");
			List<AttendanceDetails> attendanceList = new ArrayList<AttendanceDetails>();
			for (Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
				String name = entry.getKey();
				String value = entry.getValue()[0];
				if (name.contains("attendance_")) {
					String studentRollNumber = name.split("_")[1];
					String studentAttendance = value;
					AttendanceDetails attendance = new AttendanceDetails();
					attendance.setDate(attendanceDate);
					attendance.setStudentRollNumber(studentRollNumber);
					attendance.setAttendance(studentAttendance);
					attendanceList.add(attendance);
				}

			}
			boolean isAddedAttendance = attendanceService.addAttendance(attendanceList);

			if (isAddedAttendance) {
				String message = "SUCCESSFULLY ATTENDANCE ENTERED";
				response.sendRedirect("markAttendance.jsp?infoMessage=" + message);

			} else {
				throw new CannotAddAttendanceException("CANNOT MARK  ATTENDANCE");

			}

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("markAttendance.jsp?errorMessage=" + e.getMessage());
			rd.forward(request, response);

		}
	}

}
