<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Faculty Details</title>
<%
String studentRollNumber = (String) session.getAttribute("LOGGED_IN_USER_NO");
if (studentRollNumber == null) {
	response.sendRedirect("studentLogin.jsp");
}
%>

<style>
#facultyTable {
	background-color: #AAB7B8;
	font-weight: bold;
	border: none;
}

p {
	background-color: pink;
	font-weight: bolder;
	padding: 5px;
	text-align: center;
	font-size: 15px;
}
</style>
</head>
<body onload="onLoadGetId()">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<a href="studentHomePage.jsp">Previous page</a><br /> <br />
		<!-- Display Attendance Incharge Details -->
		<figure>
			<figcaption>
				<p>CONTACT INFORMATION</p>
			</figcaption>
			<br />
			<table border="1" id="facultyTable" class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</figure>
	</main>

	<script>
		/**
		 *This method fetches the fees data for a specifice student from the servlet 
		 *and gets a json data from the servlet, and writes those json data to the html. 
		 */
		function getFacultyFromServlet(studentRollNumber){
			let params = 'studentRollNumber='+studentRollNumber;
			let url = "FacultyContactServlet?"+params;
			fetch(url,{method:'get'}).then(res=> res.json()).then(res=>{
				let data = res;
				console.log(data);
				var tableData = '<thead class="thead-dark"><tr><th>INCHARGE</th><th scope="col">DETAILS</th></tr></thead>'
					tableData+= '<tbody>'
					    for(i = 0;i < data.length; i++){
				    	tableData+= '<tr>';
				    	tableData+= '<th> NAME </th>';
				    	tableData+= '<td>' + data[i].facultyName+ '</td>';
				    	tableData+= '</tr>';
				    	tableData+= '<tr>';
				    	tableData+= '<th> CLASS </th>';
				    	tableData+= '<td>' + data[i].facultyClass + '</td>';
				    	tableData+= '</tr>';
				    	tableData+= '<tr>';
				    	tableData+= '<th> EMAIL ID </th>';
				    	tableData+= '<td>' + data[i].facultyEmailId + '</td>';
				    	tableData+= '</tr>';
				    	tableData+= '<tr>';
				    	tableData+= '<th> MOBILE NUMBER </th>';
				    	tableData+= '<td>' + data[i].facultyMobileNumber + '</td>';
				    	tableData+= '</tr>';
					    }
					tableData+='</tbody>';
				    document.getElementById("facultyTable").innerHTML = tableData;				
			})
		}
		/**
		 * This method gets the parameter from the url and calls the fetch function as parameter.
		 */
		function onLoadGetId(){
			let params = new URLSearchParams(window.location.search);
			let studentRollNumber = params.get('studentRollNumber');
			getFacultyFromServlet(studentRollNumber);
			}
	</script>
</body>
</html>

