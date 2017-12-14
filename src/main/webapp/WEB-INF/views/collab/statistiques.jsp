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

</head>
<body>
	<h1 style="margin-left: 20px; text-align: center;">Statistiques</h1>
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
						<c:forEach var="visite" items="${listeVisites}">
							<tr class="active">
								<td><c:out value="${visite.chemin}" /></td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
								<td>Column content</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>


</body>
</html>