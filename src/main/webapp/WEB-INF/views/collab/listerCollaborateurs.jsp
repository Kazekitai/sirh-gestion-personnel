<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="dev.sgp.entite.Departement"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-
dist/css/bootstrap.css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body style="background-color: lightgray;">
	<h1 style="margin-left: 20px; text-align: center;">Les
		collaborateurs</h1>
	<div class="container bootstrap snippet">
		<div class="row"
			style="width: 80%; margin-left: auto; margin-right: auto;">
			<div class="col-lg-8" style="width: 100%;">
				<div class="panel panel-default">
					<div class="panel-body p-t-0">
						<div class="input-group">
							<input type="text" id="example-input1-group2"
								name="example-input1-group2" class="form-control"
								placeholder="Rechercher un collaborateur"> <span class="input-group-btn">
								<button type="button" class="btn btn-effect-ripple btn-primary">
									<i class="fa fa-search"></i>
								</button>
							</span> <input type="checkbox" id="checkboxActif" name="checkboxActif"
								class="" style="margin-left: 20px;"> <span>Voir
								les collaborateurs désactivés</span>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="row"
			style="width: 80%; margin-left: auto; margin-right: auto;margin-bottom: 20px;">
			<div class="form-group">
				<label for="departement" class="col-md-3 control-label form-label">Filtrer par département
				</label>
				<div class="col-md-9">
					<select class="form-control" name="departement">
						<%
							List<Departement> listeDepartement = (List<Departement>) request.getAttribute("listeDepartement");
							for (Departement dpt : listeDepartement) {
								String nomDpt = dpt.getNom();
						%>
						<option value="<%=nomDpt%>"><%=nomDpt%></option>
						<%
							}
						%>
					</select>
				</div>
			</div>
		</div>
		<div class="row"
			style="width: 80%; margin-left: auto; margin-right: auto;">
			<%
				List<Collaborateur> listeNoms = (List<Collaborateur>) request.getAttribute("listeNoms");
				for (Collaborateur collab : listeNoms) {
					String intitulePoste = collab.getIntitulePoste();
					String nomComplet = collab.getPrenom() + " " + collab.getNom();
					String photo = collab.getPhoto();
					String departement = collab.getDepartement().getNom();
					String email = collab.getEmailPro();
					String addresse = collab.getAdresse();
			%>
			<div class="col-sm-6">
				<div class="panel">
					<div class="panel-body p-t-10">
						<div class="media-main">
							<a class="pull-left" href="#"> <img
								class="thumb-lg img-circle bx-s" src="<%=photo%>" alt="">
							</a>
							<div class="pull-right btn-group-sm">
								<a href="#" class="btn btn-success tooltips"
									data-placement="top" data-toggle="tooltip"
									data-original-title="Edit"> <i class="fa fa-pencil"></i>
								</a> <a href="#" class="btn btn-danger tooltips"
									data-placement="top" data-toggle="tooltip"
									data-original-title="Delete"> <i class="fa fa-close"></i>
								</a>
							</div>
							<div class="info">
								<h4><%=nomComplet%></h4>
								<p class="text-muted">
									Fonction :
									<%=intitulePoste%></p>
								<p class="text-muted">
									Département :
									<%=departement%></p>

							</div>
						</div>
						<div class="clearfix"></div>
						<hr>
						<p class="text-muted">
							Email :
							<%=email%></p>
						<p class="text-muted">
							Adresse :
							<%=addresse%></p>
					</div>
				</div>
			</div>
			<%
				}
			%>

		</div>
	</div>

</body>
</html>