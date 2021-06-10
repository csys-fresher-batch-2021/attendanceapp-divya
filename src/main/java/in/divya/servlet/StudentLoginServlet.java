package in.divya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.divya.exceptions.InValidCredentialsException;
import in.divya.service.StudentService;
import in.divya.util.PasswordValidatorUtil;
import in.divya.util.StringValidatorUtil;
import in.divya.validator.RollNumberValidator;

/**
 * Servlet implementation class StudentLoginServlet
 */
@WebServlet("/StudentLoginServlet")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentLoginServlet() {
		super();
	}

	/**
	 * Student login process.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentService studentService = new StudentService();

		/**
		 * Step 1: Get form values
		 */
		try {

			String studentName = request.getParameter("studentName");
			String studentRollNumber = request.getParameter("studentRollNumber");
			String studentPassword = request.getParameter("studentPassword");
			StringValidatorUtil.isStringNotNullOrEmpty(studentName, "Cannot Accept Empty and Null Value");
			RollNumberValidator.isValidRollNumberFormat(studentRollNumber, "Invalid RollNumber Format");
			PasswordValidatorUtil.isValidPasswordFormat(studentPassword, "Invalid Password Format");
			/**
			 * Step 2: call Service
			 */
			boolean isValidStudent = studentService.studentValidation(studentName, studentRollNumber, studentPassword);
			if (isValidStudent) {
				HttpSession session = request.getSession();
				session.setAttribute("LOGGED_IN_USER", studentName);
				session.setAttribute("LOGGED_IN_USER_NO", studentRollNumber);
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			} else {
				throw new InValidCredentialsException("Invalid Student Credentials");
			}
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("studentLoginPage.jsp?errorMessage=" + e.getMessage());
			rd.forward(request, response);

		}
	}
}
