<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="in.divya.service.StudentService"%>
<%@page import="in.divya.model.StudentDetails"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>StudentInformation</title>
<style>
h3 {
	color: blue;
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<br />
	<main class="container-fluid">
		<a href="listOfStudents.jsp">Previous page</a><br />
		<!-- Display  Student Information-->
		<figure>
			<figcaption>
				<h3>DIVVLEARN SCHOOL STUDENT INFORMATION</h3>
				<br />
			</figcaption>
			<%
			String studentRollNumber = request.getParameter("allInfo");
			StudentService studentService = new StudentService();
			List<StudentDetails> studentData = studentService.studentInformation(studentRollNumber);
			for(StudentDetails studentInfo : studentData){
			%>

			<table class="table" border="1">
				<thead class="thead-dark">
					<tr>
						<th scope="col">STUDENT</th>
						<th scope="col">INFORMATION</th>
					</tr>
				<tbody>

					<tr>
						<th scope="row">STUDENT NAME</th>
						<th scope="col"><%=studentInfo.getStudentName() %></th>
					</tr>
					<tr>
						<th scope="row">FATHER NAME</th>
						<td><%=studentInfo.getFatherName() %></td>
					</tr>
					<tr>
						<th scope="row">MOTHER NAME</th>
						<td><%=studentInfo.getMotherName() %></td>
					</tr>
					<tr>
						<th scope="row">EMAIL-ID</th>
						<td><%=studentInfo.getStudentEmailId() %></td>
					</tr>
					<tr>
						<th scope="row">ROLL NUMBER</th>
						<td><%=studentInfo.getStudentRollNumber() %></td>
					</tr>

					<tr>
						<th scope="row">GENDER</th>
						<td><%=studentInfo.getGender() %></td>
					<tr>
						<th scope="row">ADDRESS</th>
						<td><%=studentInfo.getStudentAddress() %></td>
					</tr>
					<tr>
						<th scope="row">CITY</th>
						<td><%=studentInfo.getStudentCity() %></td>
					</tr>
					<tr>
						<th scope="row">PARENT OCCUPATION</th>
						<td><%=studentInfo.getOccupation() %></td>
					</tr>
					<tr>
						<th scope="row">BLOOD GROUP</th>
						<td><%=studentInfo.getStudentBloodGroup() %></td>
					</tr>
					<tr>
						<th scope="row">STANDARD</th>
						<td><%=studentInfo.getStudentStandard() %></td>
					</tr>
					<tr>
						<th scope="row">PARENT MOBILE NUMBER</th>
						<td><%=studentInfo.getParentMobileNumber() %></td>
					</tr>
					<tr>
						<th scope="row">DATE OF BIRTH</th>
						<td><%= studentInfo.getDateOfBirth() %></td>
					</tr>
				</tbody>
			</table>
			<% } %>
		</figure>
	</main>
</body>
</html>