<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.divya.service.ReasonService"%>
<%@page import="in.divya.model.ReasonDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>REASON DISPLAY</title>
<style>
label {
	font-weight: bold;
	font-size: 16px;
}

form {
	text-align: center;
}

h2 {
	color: black;
	text-align: center;
}

h4 {
	color: brown;
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<a href="facultyHomePage.jsp">Previous page</a><br />
		<!-- Display onduty or absent reasons-->
		<figure>
			<figcaption>
				<h2>REASONS FOR ABSENT AND ONDUTY</h2>
				<br />
			</figcaption>
			<label> SEARCH DATE : </label>
			<input type="text" id="myInput1" onkeyup="dateFunction()"
				placeholder="ENTER DATE" title="Type in a date">
			<br />
			<form action="ReasonRemoveServlet" method="post">
				REMOVE REASON : <input type="text" name="rollNumber" id="rollNumber"
					placeholder="ENTER ROLL NUMBER" required> DATE : <input
					type="date" name="dateOfReason" id="dateOfReason" min="2021-01-01"
					max="2021-12-31" value="<%=LocalDate.now()%>" required>
				<button class="button">REMOVE</button>
				<%
				String infoMessage = request.getParameter("infoMessage");
				if (infoMessage != null) {
					out.println("<font color='brown'>" + infoMessage + "</font>");
				}
				String errorMessage = request.getParameter("errorMessage");
				if (errorMessage != null) {
					out.println("<font color='brown'>" + errorMessage + "</font>");
				}
				%>
				<br /> <br />
			</form>
			<table border="1" class="table" id="myTable">
				<thead class="thead-dark">

					<tr>
						<th scope="col">STUDENT ROLL NUMBER</th>
						<th scope="col">DATE</th>
						<th scope="col">ATTENDANCE TYPE</th>
						<th scope="col">REASON</th>
					</tr>
				<tbody>
					<%
					String facultyEmailId = (String) session.getAttribute("LOGGED_IN_USER_ID");
					ReasonService reasonService = new ReasonService();
					List<ReasonDetails> reasonData = reasonService.displayAllReasons(facultyEmailId);
					if (reasonData != null && !reasonData.isEmpty()) {
						int i = 1;
						for (ReasonDetails reason : reasonData) {
							i++;
					%>
					<tr>
						<td><%=reason.getStudentRollNumber()%></td>
						<td><%=reason.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))%></td>
						<td><%=reason.getAttendanceType()%></td>
						<td><%=reason.getReason()%></td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td colspan="4"><h4>REASONS NOT FOUND</h4></td>
					</tr>
					<%
					}
					%>
				</tbody>
				<thead>
			</table>
		</figure>
	</main>
	<script>
		function dateFunction() {
			var input, filter, table, tr, td, i, txtValue;
			input = document.getElementById("myInput1");
			filter = input.value.toUpperCase();
			table = document.getElementById("myTable");
			tr = table.getElementsByTagName("tr");
			for (i = 0; i < tr.length; i++) {
				td = tr[i].getElementsByTagName("td")[1];
				if (td) {
					txtValue = td.textContent || td.innerText;
					if (txtValue.toUpperCase().indexOf(filter) > -1) {
						tr[i].style.display = "";
					} else {
						tr[i].style.display = "none";
					}
				}
			}
		}
	</script>
</body>
</html>