<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Departement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SGP - App</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-
dist/css/bootstrap.css">
</head>
<body>
	<div id="signupbox" style="margin-top: 50px; width: 50%"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Nouveau collaborateur</div>
			</div>
			<div class="panel-body">
				<form id="signupform" class="form-horizontal" role="form" method="post" action="ajouter">

					<div id="signupalert" style="display: none"
						class="alert alert-danger">
						<p>Erreur:</p>
						<span></span>
					</div>
						<div class="form-group">
							<label for="nom" class="col-md-3 control-label form-label">Nom</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="nom"
									placeholder="nom">
							</div>
						</div>

						<div class="form-group">
							<label for="prenom" class="col-md-3 control-label form-label">Prénom</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="prenom"
									placeholder="prénom">
							</div>
						</div>

						<div class="form-group">
							<label for="birthday" class="col-md-3 control-label form-label">Date
								de naissance </label>
							<div class="col-md-9">
								<input type="date" class="form-control" name="birthday"
									placeholder="prénom">
							</div>
						</div>

						<div class="form-group">
							<label for="adresse" class="col-md-3 control-label form-label">Adresse
							</label>
							<div class="col-md-9">
								<Textarea class="form-control" name="adresse"></Textarea>
							</div>
						</div>

						<div class="form-group">
							<label for="numSecuSocial"
								class="col-md-3 control-label form-label">Numéro de
								sécurité sociale </label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="numSecuSocial"
									placeholder="numéro de sécurité sociale">
							</div>
						</div>
						
						<div class="form-group">
							<label for="departement"
								class="col-md-3 control-label form-label">Département </label>
							<div class="col-md-9">
								<select class="form-control" name="departement">
										<%
								            List<Departement> listeNoms = (List<Departement>) request.getAttribute("listeDepartement");
								            for (Departement dpt : listeNoms) {
								                String nomDpt = dpt.getNom();
								                
								        %>
									<option value="<%=nomDpt%>"><%=nomDpt%></option>
									<%
							            }
							        %>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label for="intitulePoste"
								class="col-md-3 control-label form-label">Fonction </label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="intitulePoste"
									placeholder="fonction">
							</div>
						</div>

						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<button id="btn-signup" type="submit" class="btn btn-info">
									<i class="icon-hand-right"></i> &nbsp Créer
								</button>
								<span style="margin-left: 8px;"></span>
							</div>
						</div>

					</form>
			</div>
		</div>
	</div>

</body>
</html>