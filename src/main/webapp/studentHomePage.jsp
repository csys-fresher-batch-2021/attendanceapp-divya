<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Student Home Page</title>
<%
String rollNumber = (String) session.getAttribute("LOGGED_IN_USER_NO");
if (rollNumber == null) {
	response.sendRedirect("studentLogin.jsp");
}
%>
<style>
h3 {
	color: blue;
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<!-- This page display the student home page -->
		<figure>
			<figcaption>Student Information</figcaption>
			<br />
			<%
			String studentRollNumber = (String) session.getAttribute("LOGGED_IN_USER_NO");
			String studentName = (String) session.getAttribute("LOGGED_IN_USER");
			out.println("<h3>WELCOME " + studentName + "</h3><br/>");
			%>
			<br />

			<table class="table table-bordered">
				<tr>
					<th scope="col">ATTENDANCE DETAILS</th>
					<th scope="col">
						<button type="button" class="btn btn-primary"
							onclick="window.location.href='http://localhost:8080/app/displayAttendance.jsp'">
							VIEW ATTENDANCE</button>
					</th>
				</tr>
				<tr>
					<th scope="col">ATTENDANCE INCHARGE</th>
					<th scope="col">
						<button type="button" class="btn btn-primary"
							onclick="window.location.href='http://localhost:8080/app/facultyContact.jsp?studentRollNumber=<%=studentRollNumber%>'">CONTACT INFO</button>
					</th>
				</tr>
				<tr>
					<th scope="col">REASON INFORMATION</th>
					<th scope="col">
						<button type="button" class="btn btn-primary"
							onclick="window.location.href='http://localhost:8080/app/reasonInformation.jsp?'">INFORM</button>
					</th>
				</tr>
			</table>
		</figure>
	</main>
</body>
</html>