<%@ page language="java" contentType="text/html; charset=UTF-8" session="false"
	pageEncoding="UTF-8"%>
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

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

<title>sc2i</title>
</head>
<body>

	<main class="login-form">
		<div class="topnav">
			<a class="active" href="index2">Home</a>
		</div>

	<br/>
	
		<div class="cotainer">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card">
						<div class="card-header">S'inscrire</div>
						<div class="card-body">
							<form action="inscription" method="post">
								<div class="form-group row">
									 <div class="textco" >${error}</div>
									 <br/><br/><br/>
									<label for="email_address"
										class="col-md-4 col-form-label text-md-right">E-MailAddress</label>
									<div class="col-md-6">
										<input type="text" id="email_address" class="form-control"
											name="email" required autofocus>
									</div>
								</div>

								<div class="form-group row">
									<label for="password"
										class="col-md-4 col-form-label text-md-right">Password</label>
									<div class="col-md-6">
										<input type="password" id="password" class="form-control"
											name="password" required>
									</div>
									
								</div>
								<div class="form-group row">
									<label for="password2"
										class="col-md-4 col-form-label text-md-right">Confirm Password</label>
									<div class="col-md-6">
										<input type="password" id="password2" class="form-control"
											name="password2" required>
									</div>
									
								</div>

								<div class="form-group row">
									<label for="firstname"
										class="col-md-4 col-form-label text-md-right">Firstname</label>
									<div class="col-md-6">
										<input type="text" id="firstname" class="form-control"
											name="firstname" required>
									</div>
									
								</div>
								<div class="form-group row">
									<label for="lastname"
										class="col-md-4 col-form-label text-md-right">Password</label>
									<div class="col-md-6">
										<input type="text" id="lastname" class="form-control"
											name="lastname" required>
									</div>
									
								</div>

								<div class="col-md-6 offset-md-6">
									<button type="submit" class="btn btn-primary">
										S'inscrire</button>
								</div>

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</main>
	<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>

