package in.divya.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import in.divya.service.StudentService;

/**
 * Servlet implementation class StudentRemoveServlet
 */
@WebServlet("/StudentRemoveServlet")
public class StudentRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentRemoveServlet() {
		super();
	}

	/**
	 * To delete student process.
	 * 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentService studentService = new StudentService();
		String studentRollNumber = request.getParameter("allInfo");
		try {
			boolean isRemoved = studentService.deleteStudent(studentRollNumber);
			if (isRemoved) {
				RequestDispatcher rd = request.getRequestDispatcher(
						"listOfStudents.jsp?infoMessage=SuccessFully Deleted Student - " + studentRollNumber);
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(
						"listOfStudents.jsp?errorMessage=Cannot Delete Student - " + studentRollNumber);
				rd.forward(request, response);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
