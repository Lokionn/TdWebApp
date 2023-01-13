<%@ page language="java" contentType="text/html; charset=UTF-8"
	session="false" pageEncoding="UTF-8"%>

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
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>

<title>Page d'accueil</title>
<body>
	<main class="login-form">
		<div class="topnav">
			<a class="active" href="index2">Home</a>
		</div>

		<br />
		<div class="cotainer">
			<div class="row justify-content-center">
				<div class="col-md-8">
					<div class="card">

						<div class="card-header">
							<h2 style="text-align: center;">Bonjour utilisateur</h2>
							
						</div>
						<div class="card-body">
						<div class="textco">${error}</div>
							<form action="index2" method="post">
								<div class="col-md-6 offset-md-5">
									<button type="submit" class="btn btn-primary" style="">Connexion</button>

								</div>
								<br />
							</form>
							<form action="inscription" method="get">
								<div class="col-md-6 offset-md-5">
									<a href=inscription.jsp><button type="submit"
											class="btn btn-primary">Inscription</button></a>

								</div>

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</main>

</body>
</html>