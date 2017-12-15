<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@page import="dev.sgp.entite.Departement"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet"
	href='<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css" />' />
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet">
</head>
<body style="background-color: lightgray;">
	<h1 style="margin-left: 20px; text-align: center;">Les
		collaborateurs</h1>
	<div class="container bootstrap snippet" style="width: 100%;">
		<form action="lister" method="get"
			style="display: inline-table; width: 100%;">
			<div class="row"
				style="width: 100%; margin-left: auto; margin-right: auto; width: 100%;">
				<div class="col-lg-8" style="width: 100%;">
					<div class="panel panel-default">
						<div class="panel-body p-t-0" style="background-color: lightgray;">
							<div class="input-group">
								<input type="text" id="rechercheCollab" name="rechercheCollab"
									class="form-control" placeholder="Rechercher un collaborateur">
								<span class="input-group-btn">
									<button type="submit" class="btn btn-effect-ripple btn-primary"
										style="margin-left: 10px;">Rechercher</button>
								</span> <input type="checkbox" id="checkboxActif" name="checkboxActif"
									value="checked" class="" style="margin-left: 20px;" ${checked}> <span>Voir
									les collaborateurs désactivés</span>
							</div>
							<div class="row"
								style="width: 80%; margin-left: auto; margin-right: auto; margin-bottom: 20px;">
								<div class="form-group">
									<label for="departement"
										class="col-md-3 control-label form-label">Filtrer par
										département</label>
									<div class="col-md-9">
										<div class="input-group">

											<select id="choixDept" name="choixDept" class="form-control">
												<option value="${selected}" selected>${selected}</option>
												<c:set var="tous" value="Tous" />
												<c:if test="${selected != tous}">
													<option value="Tous">Tous</option>
												</c:if>
												<c:forEach items="${listeDepartement}" var="departements">
													<c:if test="${departements.nom != selected}">
														<option value="${departements.nom}">${departements.nom}</option>
													</c:if>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</form>
		<div class="row"
			style="width: 100%; margin-left: auto; margin-right: auto;">
			<c:forEach var="collab" items="${listeCollab}">
				<div class="col-sm-6">
					<div class="panel">
						<div class="panel-body p-t-10">
							<div class="media-main">
								<a class="pull-left" href="#"> <img
									class="thumb-lg img-circle bx-s" src="${collab.photo}" alt="">
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
									<h4>${collab.prenom} ${collab.nom}</h4>
									<p class="text-muted">Fonction : ${collab.intitulePoste}</p>
									<p class="text-muted">Département :	${collab.departement.nom}</p>
								</div>
							</div>
							<div class="clearfix"></div>
							<hr>
							<p class="text-muted">
								Email :
								<c:out value="${collab.emailPro}" />
							</p>
							<p class="text-muted">
								Adresse :
								<c:out value="${collab.adresse}" />
							</p>
							<c:if test="${collab.actif == true}">
								<p class="text-muted" style="color:green"><strong>Actif</strong></p>
							</c:if>
							<c:if test="${collab.actif == false}">
								<p class="text-muted" style="color:red"><strong>Innactif</strong></p>
							</c:if>
						</div>
					</div>
				</div>
			</c:forEach>


		</div>
	</div>

</body>
</html>