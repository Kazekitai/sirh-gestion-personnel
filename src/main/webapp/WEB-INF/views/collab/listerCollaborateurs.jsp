<%@page import="java.util.List"%>
<%@page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SGP - App</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-
dist/css/bootstrap.css">
</head>
<body>
	<h1 style="margin-left: 20px;">Les collaborateurs</h1>
	<ul>
		<%
			List<Collaborateur> listeNoms = (List<Collaborateur>) request.getAttribute("listeNoms");
			for (Collaborateur collab : listeNoms) {
				String matricule = collab.getMatricule();
				String nomComplet = collab.getPrenom() + " " + collab.getNom();
				String date = collab.getDateNaissance().getDayOfMonth() + "-" + collab.getDateNaissance().getMonth().getValue() + "-" + 
						collab.getDateNaissance().getYear();
				String addresse = collab.getAdresse();
				String numSecu = collab.getNumSecuSocial();
				String dateInscription = collab.getDateHeureCreation().getDayOfMonth() + "-" + collab.getDateHeureCreation().getMonth().getValue() + "-" + 
				collab.getDateHeureCreation().getYear() + " à " + collab.getDateHeureCreation().getHour() + ":" + collab.getDateHeureCreation().getMinute();
		%>
		<li><strong><%=nomComplet%></strong>
			<ul>
				<li>Matricule : <%=matricule%></li>
				<li>Date d'inscription : <%=dateInscription%></li>
				<li>Date de naissance : <%=date%></li>
				<li>Adresse : <%=addresse%></li>
				<li>Numéro de sécurité sociale : <%=numSecu%></li>
			</ul>
		</li>
		<br><br>
		<%
			}
		%>
	</ul>
	
</body>
</html>