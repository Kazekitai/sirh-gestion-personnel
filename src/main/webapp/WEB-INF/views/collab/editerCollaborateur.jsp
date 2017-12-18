<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Departement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SGP - App</title>
<link rel="stylesheet"
	href='<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css" />' />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="<c:url value="/bootstrap-3.3.7-dist/js/bootstrap.min.js" />"></script>

</head>
<body style="background-color: lightgray;">
	<c:url value="lister" var="collab"></c:url>
	<div id="signupbox" style="margin-top: 50px; width: 50%"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="form-group">
			<a class="pull-left" href="#"> <img
				class="thumb-lg img-circle bx-s" src="${collaborateur.photo}" alt=""
				style="margin-right: 50px;">
			</a>
		</div>

		<div class="form-group">
			<div class="col-md-9">
				<form id="signupform" class="form-horizontal" role="form"
					method="post" action="editer">
					<div class="row">
						<h1>${collaborateur.prenom} ${collaborateur.nom} - ${collaborateur.matricule}</h1>
						<input type="checkbox" id="checkboxActif" name="checkboxActif"
							value="checked" class="" style="margin-left: 20px;"> <span>Désactiver</span>
					</div>
					<div class="panel panel-info">
						<div class="panel-heading">
							<div class="panel-title">Identité</div>
						</div>
						<div class="panel-body">
							<input type="hidden" value="${collaborateur.matricule}"
								name="cmatricule" />
							<div id="signupalert" style="display: none"
								class="alert alert-danger">
								<p>Erreur:</p>
								<span></span>
							</div>
							<div class="form-group">
								<label for="civilite" class="col-md-3 control-label form-label">Civilité</label>
								<div class="col-md-9">
									<select type="text" class="form-control" name="civilite">
										<c:if test='${collaborateur.civilite == "Mr"}'>
											<option value="Mr" selected>Mr</option>
											<option value="Mme">Mme</option>
										</c:if>
										<c:if test='${collaborateur.civilite == "Mme"}'>
											<option value="Mr">Mr</option>
											<option value="Mme" selected>Mme</option>
										</c:if>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="nom" class="col-md-3 control-label form-label">Nom</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name="nom"
										value="${collaborateur.nom}" readonly>
								</div>
							</div>

							<div class="form-group">
								<label for="prenom" class="col-md-3 control-label form-label">Prénom</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name="prenom"
										value="${collaborateur.prenom}" readonly>
								</div>
							</div>

							<div class="form-group">
								<label for="birthday" class="col-md-3 control-label form-label">Date
									de naissance </label>
								<div class="col-md-9">
									<input type="date" class="form-control" name="birthday"
										value="${collaborateur.dateNaissance}" readonly>
								</div>
							</div>

							<div class="form-group">
								<label for="adresse" class="col-md-3 control-label form-label">Adresse</label>
								<div class="col-md-9">
									<Textarea class="form-control" name="adresse" required>${collaborateur.adresse}</Textarea>
								</div>
							</div>

							<div class="form-group">
								<label for="numSecuSocial"
									class="col-md-3 control-label form-label">Numéro de
									sécurité sociale </label>
								<div class="col-md-9">
									<input type="text" class="form-control" name="numSecuSocial"
										value="${collaborateur.numSecuSocial}" readonly>
								</div>
							</div>
							<div class="panel-group" id="accordion">
								
								<div class="panel panel-default" style="background-color: lightblue;">
									<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" class="panel-title ">
										<div class="panel-heading">
											<h4 class="panel-title">
												Poste
											</h4>
										</div>
									</a>
									<div id="collapseOne" class="panel-collapse collapse">
										<div class="panel-body">
											<div class="form-group">
												<label for="intitulePoste"
													class="col-md-3 control-label form-label">Fonction
												</label>
												<div class="col-md-9">
													<input type="text" class="form-control"
														name="intitulePoste"
														value="${collaborateur.intitulePoste}">
												</div>
											</div>
											<div class="form-group">
												<label for="departement"
													class="col-md-3 control-label form-label">Département
												</label>
												<div class="col-md-9">
													<select id="departement" class="form-control"
														name="departement">
														<c:forEach var="departements" items="${listeDepartement}">
															<c:if
																test="${collaborateur.departement.nom ==  departements.nom}">
																<option value="${departements.nom}" selected>${departements.nom}</option>
															</c:if>
															<c:if
																test="${collaborateur.departement.nom !=  departements.nom}">
																<option value="${departements.nom}">${departements.nom}</option>
															</c:if>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="panel panel-default" style="background-color: lightblue;">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" class="panel-title ">
										<div class="panel-heading">
											<h4 class="panel-title">
												Coordonnées Banquaires
											</h4>
										</div>
									</a>
									<div id="collapseTwo" class="panel-collapse collapse">
										<div class="panel-body">
											<div class="form-group">
												<label for="banque"
													class="col-md-3 control-label form-label">Banque </label>
												<div class="col-md-9">
													<input type="text" class="form-control" name="banque"
														value="${collaborateur.banque}">
												</div>
											</div>
											<div class="form-group">
												<label for="bic" class="col-md-3 control-label form-label">BIC
												</label>
												<div class="col-md-9">
													<input type="text" class="form-control" name="bic"value="${collaborateur.bic}">
												</div>
											</div>
											<div class="form-group">
												<label for="ban" class="col-md-3 control-label form-label">BAN
												</label>
												<div class="col-md-9">
													<input type="text" class="form-control" name="ban"
														value="${collaborateur.ban}">
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>

							<div class="form-group">
								<!-- Button -->
								<div class="col-md-offset-3 col-md-9">
									<button id="btn-signup" type="submit" class="btn btn-info">
										<i class="icon-hand-right"></i> &nbsp Sauvegarder
									</button>
									<a href="${collab}" class="btn btn-info"
										style="margin-left: 10px;">Annuler</a>
								</div>
							</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>