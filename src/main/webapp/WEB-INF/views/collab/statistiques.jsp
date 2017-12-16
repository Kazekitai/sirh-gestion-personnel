<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SGP - App</title>
<link rel="stylesheet"
	href='<c:url value="/bootstrap-3.3.7-dist/css/bootstrap.css" />' />

</head>
<body>
	<c:url value="/collaborateurs/lister" var="collab"></c:url>
	<c:url value="statistiques" var="stat"></c:url>
	<div class="header">
		<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="logo">
			<a class="navbar-brand" href="home.html"> <img
				src="https://bootdey.com/img/Content/user_1.jpg" alt="logo"
				width="50" height="50" class="img-circle">
			</a>
		</div>
		 
		<div class="container-fluid">
			<div class="navbar-header">
				 <a class="navbar-brand" href="collaborateurs/lister">SGP - App</a>
			</div>
			<ul id="randoNavbar" class="nav navbar-nav">
				<li><a href="${collab}">Collaborateurs</a></li>       
				<li><a href="${stat}">Statistiques</a></li>      
			</ul>
			     
		</div>
		</nav>
	</div>
	<h1 style="margin-left: 20px; text-align: center; margin-top: 90px;">Statistiques</h1>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered">
					<thead class="thead-light">
						<tr>
							<th scope="col">Chemin</th>
							<th scope="col">Nombre de visites</th>
							<th scope="col">Min (ms)</th>
							<th scope="col">Max (ms)</th>
							<th scope="col">Moyenne (ms)</th>
						</tr>
					</thead>
					<tbody>
						
						<c:forEach items="${statObject}" var="item">
							<tr class="active">
								<td>${item.get("chemin")}</td>
								<td>${item.get("nbVisites")}</td>
								<td>${item.get("min")}</td>
								<td>${item.get("max")}</td>
								<td>${item.get("moy")}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
	</div>


</body>
</html>