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




<title>Good Bye Row</title>
<body class="body2">


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

		<table data-pagination="true" data-search="true" data-toggle="table"
			data-page-list="[5, 10, 25, 50, 100, all]" class="table">
			<thead>
				<tr>
					<th scope="col">User ID</th>
					<th scope="col">Email</th>
					<th scope="col">Pw</th>
					<th scope="col">Firstname</th>
					<th scope="col">Lastname</th>
					<th scope="col">DateCrea</th>

				</tr>
			</thead>
			<tbody>
				<tr class="rowhovered">
					<td>Plic</td>
					<td>plac</td>
					<td>ploc</td>
					<td>pluc</td>
					<td>plek</td>
					<td>pwak</td>

				</tr>
				<tr class="rowhovered">
					<td>Plic</td>
					<td>plac</td>
					<td>ploc</td>
					<td>pluc</td>
					<td>plek</td>
					<td>pwak</td>

				</tr>
				<tr class="rowhovered">
					<td>Plic</td>
					<td>plac</td>
					<td>ploc</td>
					<td>pluc</td>
					<td>plek</td>
					<td>
						<div class="background-highlight"></div>
						<div class="highlight"></div>
						<p>pwak</p>
						<div class="burn">
							<div class="flame"></div>
							<div class="flame"></div>
							<div class="flame"></div>
							<div class="flame"></div>
							<div class="flame"></div>
							<div class="flame"></div>
							<div class="flame"></div>
							<div class="flame"></div>
							<div class="flame"></div>
							<div class="flame"></div>
						</div>
					</td>

				</tr>
				<tr class="rowhovered">
					<td>Plic</td>
					<td>plac</td>
					<td>ploc</td>
					<td>pluc</td>
					<td>plek</td>
					<td> pwak</td>

				</tr>
			</tbody>
		</table>




	</main>


</body>
</html>
