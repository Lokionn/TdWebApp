<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Fonts -->
<link rel="dns-prefetch" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css?family=Raleway:300,400,600"
	rel="stylesheet" type="text/css">

<link rel="stylesheet" href="css/style.css">

<link rel="icon" href="Favicon.png">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap-table@1.18.2/dist/bootstrap-table.min.css">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
<script
	src="https://unpkg.com/bootstrap-table@1.21.2/dist/bootstrap-table.min.js"></script>




<title>Employees</title>
<body>


	<main class="login-form">
		<div class="topnav">
			<a class="active" href="index2">Home</a> <a href="add">Ajouter
				User</a> <a href="liste">Liste Users</a> <a href="add2">Ajouter
				Employee</a><a href="liste2">Liste Employees</a><a href="about">About</a>
			<form action="logout" method="post">

				<span style="color: red; font-size: 12px">${error }</span>

				<button type="submit" class="btn btn-primary btndeco">Deconnection</button>
				<br /> <br />


			</form>
		</div>
	<br/>
	<div class="textco"> Voici les donn?es de TOUT LE MONDE, utilisez les avec sagesse. </div>
	<br/>



		<table data-pagination="true" data-search="true" data-toggle="table"
			data-page-list="[5, 10, 25, 50, 100, all]" class="table">
			<thead>
				<tr>
					<th scope="col">Employee ID</th>
					<th scope="col">Firstname</th>
					<th scope="col">Lastname</th>
					<th scope="col">StartDate</th>
					<th scope="col">EndDate</th>
					<th scope="col">Title</th>
					<th scope="col">Assigned Branch ID</th>
					<th scope="col">DeptId</th>
					<th scope="col">Superior Emp ID</th>
					<th scope="col">Edit</th>
					<th scope="col">Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="emp">
					<c:choose>
						<c:when test="${emp.empid > 0}">
							<tr class="rowhovered">
								<td>${emp.empid }</td>
								<td>${emp.firstname}</td>
								<td>${emp.lastname }</td>
								<td>${emp.startdate}</td>
								<td>${emp.enddate}</td>
								<td>${emp.title}</td>
								<td>${emp.assignedbranchid}</td>
								<td>${emp.deptid}</td>
								<td>${emp.superiorempid}</td>
								<td><a class="active" href="update2?id=${emp.empid}"><i
										class="fa-regular fa-pen-to-square"></i></a></td>
								<td><a class="active" href="delete2?id=${emp.empid}"
									onclick="return confirm('Are you sure?')"><i
										class="fa-solid fa-trash"></i></a></td>

							</tr>
						</c:when>
					</c:choose>
				</c:forEach>

			</tbody>
		</table>





	</main>


</body>
</html>
