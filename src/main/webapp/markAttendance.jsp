<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="in.divya.service.StudentService"%>
<%@page import="in.divya.model.StudentDetails"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>AttendancePage</title>
<style>
form {
	text-align: center;
}

.button {
	background-color: #555555; /* Green */
	border: none;
	color: white;
	padding: 10px 25px;
	display: inline-block;
	font-size: 16px;
	margin: 2px 3px;
	cursor: pointer;
}

h2 {
	color: black;
	text-align: center;
}

h4 {
	color: black;
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<a href="facultyHomePage.jsp">Previous page</a><br />
		<!-- Attendance Portal-->
		<figure>
			<figcaption>
				<h2>ATTENDANCE PORTAL PAGE</h2>
				<br />
			</figcaption>

			<%
			String facultyEmailId = (String) session.getAttribute("LOGGED_IN_USER_ID");
			StudentService studentDetailService = new StudentService();
			List<StudentDetails> allStudentList = studentDetailService.studentsList(facultyEmailId);
			%>
			<form action="AttendanceAddServlet" method="get">
				<label for="date">DATE : </label> <input type="date"
					name="dateOfAttendance" id="dateOfAttendance" min="2021-01-01"
					max="2021-12-31" value="<%=LocalDate.now()%>" required> <br />
				<br />
				<table class="table" border="1">
					<thead class="thead-dark">
						<tr>
							<th scope="col">STUDENT NAME</th>
							<th scope="col">ROLL NUMBER</th>
							<th scope="col">PRESENT</th>
							<th scope="col">ABSENT</th>
							<th scope="col">ONDUTY</th>
						</tr>
					</thead>
					<tbody>
						<%
						if (allStudentList != null && !allStudentList.isEmpty()) {
							int i = 1;
							for (StudentDetails allInfo : allStudentList) {
								i++;
						%>
						<tr>
							<td><%=allInfo.getStudentName()%></td>
							<td><%=allInfo.getStudentRollNumber()%></td>
							<td><input type="radio"
								name="attendance_<%=allInfo.getStudentRollNumber()%>"
								data-student-rollNo="<%=allInfo.getStudentRollNumber()%>"
								value="PRESENT" required></td>
							<td><input type="radio"
								name="attendance_<%=allInfo.getStudentRollNumber()%>"
								value="ABSENT" required></td>
							<td><input type="radio"
								name="attendance_<%=allInfo.getStudentRollNumber()%>"
								value="ONDUTY" required></td>
						</tr>
						<%
						}
						} else {
						%>
						<tr>
							<td colspan="5"><h4>RECORD NOT FOUND</h4></td>
						</tr>
						<%
						}
						%>

					</tbody>
				</table>
				<br />
				<button class="button">SUBMIT</button>
				<br /> <br />
				<%
				String errorMessage = request.getParameter("errorMessage");
				if (errorMessage != null) {
					out.println("<font color='black'>" + errorMessage + "</font>");
				}
				String infoMessage = request.getParameter("infoMessage");
				if (infoMessage != null) {
					out.println("<font color='black'>" + infoMessage + "</font>");
				}
				%>

			</form>
		</figure>
	</main>
</body>
</html>