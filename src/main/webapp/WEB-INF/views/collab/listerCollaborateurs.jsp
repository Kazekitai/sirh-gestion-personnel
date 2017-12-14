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
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body style="background-color: lightgray;">
	<h1 style="margin-left: 20px;">Les collaborateurs</h1>
<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-lg-8">
            <div class="panel panel-default">
                <div class="panel-body p-t-0">
                    <div class="input-group">
                        <input type="text" id="example-input1-group2" name="example-input1-group2" class="form-control" placeholder="Rechercher">
                        <span class="input-group-btn">
                            <button type="button" class="btn btn-effect-ripple btn-primary"><i class="fa fa-search"></i></button>
                        </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
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
        <div class="col-sm-6">
            <div class="panel">
                <div class="panel-body p-t-10">
                    <div class="media-main">
                        <a class="pull-left" href="#">
                            <img class="thumb-lg img-circle bx-s" src="https://bootdey.com/img/Content/user_1.jpg" alt="">
                        </a>
                        <div class="pull-right btn-group-sm">
                            <a href="#" class="btn btn-success tooltips" data-placement="top" data-toggle="tooltip" data-original-title="Edit">
                                <i class="fa fa-pencil"></i>
                            </a>
                            <a href="#" class="btn btn-danger tooltips" data-placement="top" data-toggle="tooltip" data-original-title="Delete">
                                <i class="fa fa-close"></i>
                            </a>
                        </div>
                        <div class="info">
                            <h4><%=nomComplet%></h4>
                            <p class="text-muted">Matricule : <%=matricule%></p>
                            <p class="text-muted">Date d'inscription : <%=dateInscription%></p>
                            
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <hr>
                    <p class="text-muted">Date de naissance : <%=date%></p>
                    <p class="text-muted">Adresse : <%=addresse%></p>
                    <p class="text-muted">Numéro de sécurité sociale : <%=numSecu%></p>
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