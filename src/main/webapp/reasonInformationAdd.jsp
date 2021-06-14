<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.time.LocalDate"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>APPLY</title>
<style>
form {
	text-align: center;
}

label {
	font-weight: bold;
	width: 200px;
	font-size: 16px;
}

h2 {
	color: blank;
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<%
		String studentRollNumber = (String) session.getAttribute("LOGGED_IN_USER_NO");
		%>
		<a href="facultyHomePage.jsp">Previous page</a><br /> <br />
		<h2>REASON INFORMATION FORM</h2>
		<br /> <br />
		<form action="ReasonServlet" method="post">
			<label>STUDENT ROLL NUMBER : </label> <input type="text"
				name="rollNumber" id="rollNumber" placeholder="Enter Student Roll Number"
				required><br /> <br /> <label>DATE : </label> <input
				type="date" name="date" id="date" min="2021-01-01" max="2021-12-31"
				value="<%=LocalDate.now()%>" required> <br /> <br /> <label>TYPE
				: </label><br /> <label for="absent"> <input type="radio"
				id="absent" name="attendanceType" value="ABSENT" required>
				ABSENT
			</label> <br /> <label for="onDuty"> <input type="radio" id="onDuty"
				name="attendanceType" value="ONDUTY" required> ONDUTY
			</label> <br /> <br /> <label>REASON : </label><input type="text"
				placeholder="Enter your reason" name="reason"
				title="reason field should not be empty" required><br /> <br />
			<button type="submit" class="btn btn-primary">ADD</button>
			<br /> <br />
			<%
			String errorMessage = request.getParameter("errorMessage");
			if (errorMessage != null) {
				out.println("<font color='blue'>" + errorMessage + "</font>");
			}
			String infoMessage = request.getParameter("infoMessage");
			if (infoMessage != null) {
				out.println("<font color='blue'>" + infoMessage + "</font>");
			}
			%>
		</form>
	</main>
</body>
</html>