package in.divya.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.divya.util.DateValidatorUtil;

/**
 * Servlet implementation class AttendanceDisplayServlet
 */
@WebServlet("/AttendanceDisplayServlet")
public class AttendanceDisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AttendanceDisplayServlet() {
		super();
	}

	/**
	 * find attendance by date
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			boolean isValid = true;
			String date = request.getParameter("dateOfAttendance");
			LocalDate attendanceDate = DateValidatorUtil.isDateFormatOrNot(date, "InValid Date Format");
			isValid = DateValidatorUtil.isNotAFutureDate(attendanceDate, "Date cannot be a future date");
			if (isValid) {
				RequestDispatcher rd = request
						.getRequestDispatcher("dayAttendance.jsp?attendanceDate=" + attendanceDate);
				rd.forward(request, response);

			}

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request
					.getRequestDispatcher("allAttendanceDisplay.jsp?errorMessage=" + e.getMessage());
			rd.forward(request, response);

		}

	}

}
