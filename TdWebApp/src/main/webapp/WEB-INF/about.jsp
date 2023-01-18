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

<link rel="icon" href="Favicon.png">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<link rel="stylesheet" href="css/style.css">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
	crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/jquery/dist/jquery.min.js"></script>
<script
	src="https://unpkg.com/bootstrap-table@1.21.2/dist/bootstrap-table.min.js"></script>




<title>About</title>
<body>


	<main class="login-form">
		<div class="topnav">
			<a class="active" href="index2">Home</a> <a href="add">Ajouter
				User</a> <a href="liste">Liste Users</a> <a href="add2">Ajouter
				Employee</a><a href="liste2">Liste Employees</a> <a href="about">About</a>
			<form action="logout" method="post">



				<button type="submit" class="btn btn-primary btndeco">Deconnection</button>
				<br /> <br />


			</form>
		</div>
		<div class="pagecontent">

		<!-- The video -->
		<video autoplay muted loop id="myVideo">
			<source src="video/Zooming out from Earth (4K).mp4" type="video/mp4">
		</video>

		<!-- Optional: some overlay text to describe the video -->
		<div class="content">
			<h1>A propos de notre WebApp</h1>
			<p>
				La société LogCorp est fière de vous présenter cette WebApp très
				perfectionnée. Ici vous ne trouverez ni problème de lien entre les
				pages, ni fautes d'orthographe ni même encore d'erreur 500 ou 404. <br />
				Vous pourrez profitez de fonctionnalité inédite comme... <br /> LA
				CREATION D'USERS FICTIFS <br /> ou bien <br /> L'EDITING DES
				PROFILS AINSI CREES <br /> mais surtout, et accrochez vous bien <br />
				LA CONSULTATION DE LA LISTE DE TOUS LES USERS AVEC PLEIN DROIT POUR
				TOUS !!!! <br> LogCorp tient à remercier chaleureusement ses
				collaborateurs sans qui rien de tout ceci n'aurait été possible : <br />
				Hugo, Karim, Maxime, Mira, Luca, notre cher et valeureux groupe 1 ainsi que bien
				entendu Yahya. <br /> Encore une fois, merci.
			</p>
			<!-- Use a button to pause/play the video with JavaScript -->
			<button id="myBtn" onclick="myFunction()">Pause</button>
		
		</div>


		<br />
</div>
	</main>

	<script>
		var video = document.getElementById("myVideo");
		var btn = document.getElementById("myBtn");
		document.querySelector('video').playbackRate = 10.0;
		function myFunction() {
			if (video.paused) {
				video.play();
				btn.innerHTML = "Pause";
			} else {
				video.pause();
				btn.innerHTML = "Play";
			}
		}
	</script>

</body>
</html>
