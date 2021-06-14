package in.divya.servlet;

import java.io.IOException;

import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.divya.exceptions.InValidCredentialsException;
import in.divya.model.ReasonDetails;
import in.divya.service.ReasonService;
import in.divya.util.DateValidatorUtil;
import in.divya.util.StringValidatorUtil;
import in.divya.validator.RollNumberValidator;

/**
 * Servlet implementation class ReasonServlet
 */
@WebServlet("/ReasonServlet")
public class ReasonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReasonServlet() {
		super();
	}

	/**
	 * Get reason for absent or onduty
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ReasonService reasonService = new ReasonService();
		try {
			ReasonDetails reason = new ReasonDetails();
			String studentRollNumber = request.getParameter("rollNumber");
			String date = request.getParameter("date");
			String attendanceType = request.getParameter("attendanceType");
			String typeReason = request.getParameter("reason");
			RollNumberValidator.isValidRollNumberFormat(studentRollNumber, "Invalid RollNumber Format");
			LocalDate attendanceDate = DateValidatorUtil.isDateFormatOrNot(date, "Invalid Date Format");
			StringValidatorUtil.isStringNotNullOrEmpty(attendanceType,
					"attendanceType cannot accept empty and null value");
			StringValidatorUtil.isStringNotNullOrEmpty(typeReason, "reason cannot Accept Empty and Null Value");
			reason.setStudentRollNumber(studentRollNumber);
			reason.setDate(attendanceDate);
			reason.setAttendanceType(attendanceType);
			reason.setReason(typeReason);
			boolean isAddedStudent = reasonService.addReason(reason);
			if (isAddedStudent) {
				String message = "SUCCESSFULLY APPLIED";
				response.sendRedirect("reasonInformation.jsp?infoMessage=" + message);

			} else {
				throw new InValidCredentialsException("CANNOT REASON ADDED");

			}

		} catch (Exception e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("reasonInformation.jsp?errorMessage=" + e.getMessage());
			rd.forward(request, response);

		}
	}
}
