<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="in.divya.service.StudentService"%>
<%@page import="in.divya.model.StudentDetails"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>List Of Students</title>
<style>
h3 {
	color: blue;
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
		<!-- Display All Student Information-->
		<figure>
			<figcaption>
				<h3>DIVVLEARN SECONDARY SCHOOL</h3>
				<br />
			</figcaption>

			<%
			String facultyEmailId = (String) session.getAttribute("LOGGED_IN_USER_ID");
			StudentService studentService = new StudentService();
			List<StudentDetails> listStudents = studentService.studentsList(facultyEmailId);
			%>

			<table class="table" border="1">

				<thead class="thead-dark">
					<tr>
						<th scope="col">STUDENT NAME</th>
						<th scope="col">ROLL NUMBER</th>
						<th scope="col">PERSONAL INFORMATION</th>
						<th scope="col">ATTENDANCE</th>
						<th scope="col">DELETE</th>
					</tr>
				</thead>
				<tbody>
					<%
					if (listStudents != null && !listStudents.isEmpty()) {
						int i = 1;
						for (StudentDetails allInfo : listStudents) {
							i++;
					%>
					<tr>
						<td><%=allInfo.getStudentName()%></td>

						<td><%=allInfo.getStudentRollNumber()%></td>
						<td><a
							href="studentInformation.jsp?allInfo=<%=allInfo.getStudentRollNumber()%>">VIEW
						</a></td>
						<td><a
							href="studentIndividualAttendance.jsp?allInfo=<%=allInfo.getStudentRollNumber()%>">VIEW
						</a></td>
						<td><a
							href="StudentRemoveServlet?allInfo=<%=allInfo.getStudentRollNumber()%> "
							onclick="return deleteConfirmation('<%=allInfo.getStudentRollNumber()%>')">DELETE
						</a></td>
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
		</figure>
	</main>
	<script>
		function deleteConfirmation(studentRollNumber) {
			if (confirm("Are You sure want to delete " + studentRollNumber)) {
			} else {
				event.preventDefault();
			}
		}
	</script>
</body>
</html>