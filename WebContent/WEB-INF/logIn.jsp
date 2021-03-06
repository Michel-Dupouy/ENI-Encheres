<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>ENI-Enchères | Log In</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous" />

<!-- Custom styles for this template -->
<link href="css/login.css" rel="stylesheet" />
</head>


<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark my-navbar">
		<div class="container ">
        
			<!--<img class="mr-3" src="eni.jpg" width="50">-->
			<a class="navbar-brand" href="AccueilServlet"> <img class="logo-gris me-3"
				src="./images/auction.png" width="50"> ENI Enchères
			</a>
			
			</div>
	</nav>
	<div class="container mt-5">
		<div class="card card-container d-flex justify-content-center ">
			<img id="profile-img" class="profile-img-card" src="images/user.png" />
			<form action="LoginServlet" method="post" class="form-signin mb-5">
				<div class="groupeFormulaire row mt-3">
					<div class="col-5 d-flex justify-content-center">
						<label>Identifiant :</label>
					</div>
					<div class="col-7">
						<input type="text" name="nom" id="inputEmail" class="form-control"
							placeholder="Pseudo ou Adresse mail" required autofocus />
					</div>
				</div>
				<div class="groupeFormulaire row mt-3">
					<div class="col-5 d-flex justify-content-center">
						<label>Mot de passe :</label>
					</div>
					<div class="col-7">
						<input type="password" name="password" id="inputPassword"
							class="form-control" placeholder="******" required />
					</div>
				</div>
				<div class="groupeFormulaire row mt-3">
					<div class="col-5 d-flex justify-content-center">
						<button type="submit" class="btn btn-signin">Connexion</button>
					</div>
					<div class="col-7 divColumn ">
						<div>
							<label> <input type="checkbox" value="remember-me" /> Se
								souvenir de moi
							</label>
						</div>
						<div class="mt-2">
							<a href="#" class="forgot-password"> Mot de passe oublié? </a>
						</div>
					</div>
				</div>
			</form>


				<div class="d-flex justify-content-center">
				<a href="InscriptionServlet"><button type="submit" class="btn btn-signin">Créer un compte</button></a>
			</div>

			${message}
		</div>
		<!-- /card-container -->
	</div>
	<!-- /container -->
	<!-- Footer-->
	<footer class="py-5  my-navbar mt-3">
		<div class="container  ">

			<p class="m-0  text-white text-center ">
				<!-- <img class="me-3" src="./images/eni.jpg" width="100">-->
				Copyright &copy; ENI Enchères ENI 2021
			</p>
		</div>
	</footer>

</body>

</html>
