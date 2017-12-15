package dev.sgp.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurControlleur  extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
		ServletException, IOException {
		
		// recupere la valeur d'un parametre dont le nom est matricule
		String matricule = req.getParameter("matricule");
		resp.setContentType("text/html");
		
		// code HTML ecrit dans le corps de la reponse si aucun matricule
		if(matricule == null) {
			resp.setStatus(400);
			matricule = "Un matricule est attendu";
		}
		
		// code HTML ecrit dans le corps de la reponse
		resp.getWriter().write("<h1>Edition de collaborateur</h1>"
		+ "<p>Matricule : "+ matricule +  "</p>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
		ServletException, IOException {
		// recupere la valeur d'un parametre dont le nom est matricule
		String matricule = req.getParameter("matricule");
		
		// recupere la valeur d'un parametre dont le nom est titre
				String titre = req.getParameter("titre");
				
		// recupere la valeur d'un parametre dont le nom est nom
		String nom = req.getParameter("nom");
				
		// recupere la valeur d'un parametre dont le nom est prenom
		String prenom = req.getParameter("prenom");
		
		resp.setContentType("text/html");
		String msg = "";
		if(matricule == null || titre == null || nom == null || prenom == null) {
			resp.setStatus(400);
			msg += "<br>Les paramètres suivants sont incorrects: "
					+ "<ul>";
			if(matricule == null) {
				msg += "<li>matricule</li>";
			}
			if(titre == null) {
				msg += "<li>titre</li>";
			}
			if(nom == null) {
				msg += "<li>nom</li>";
			}
			if(prenom == null) {
				msg += "<li>prenom</li>";
			}
			msg += "</ul>";
					
		} else {
			msg += "<ul>"
			+ "<li>Matricule = "+ matricule + "</li>"
			+ "<li>Titre = "+ titre + "</li>"
			+ "<li>Nom = "+ nom + "</li>"
			+ "<li>Prénom = "+ prenom + "</li>"
			+ "</ul>";
		}
		// code HTML ecrit dans le corps de la reponse
		resp.getWriter().write("<h1>Création d'un collaborateur</h1>"
		+ msg);

	}

}
