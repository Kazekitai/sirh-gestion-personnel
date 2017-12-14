package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class AjouterCollaborateurControlleur extends HttpServlet {
	/**
	 * Constante pour le service technique des collaborateurs (sauvegarde des données en mémoire)
	 */
	private final CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// utilisation du service COLLAB_SERVICE
		req.getRequestDispatcher("/WEB-INF/views/collab/ajouterCollaborateur.jsp").forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// recupere la valeur d'un parametre dont le nom est matricule
//		String matricule = req.getParameter("matricule");

		// recupere la valeur d'un parametre dont le nom est nom
		String nom = req.getParameter("nom");

		// recupere la valeur d'un parametre dont le nom est prenom
		String prenom = req.getParameter("prenom");

		// recupere la valeur d'un parametre dont le nom est dateNaissance
		String dateNaissance = req.getParameter("birthday");

		// recupere la valeur d'un parametre dont le nom est adress
		String adresse = req.getParameter("adresse");

		// recupere la valeur d'un parametre dont le nom est numSecuSocial
		String numSecuSocial = req.getParameter("numSecuSocial");

		resp.setContentType("text/html");
		String msg = "";
		if (numSecuSocial == null || numSecuSocial.length() != 15 || numSecuSocial.matches("[0-9]+") || nom == null || prenom == null || dateNaissance == null
				|| adresse == null) {
			resp.setStatus(400);
			msg += "<br>Les paramètres suivants sont incorrects: " + "<ul>";
			if (nom == null) {
				msg += "<li>nom</li>";
			}
			if (prenom == null) {
				msg += "<li>prenom</li>";
			}
			if (dateNaissance == null) {
				msg += "<li>date de naissance</li>";
			}
			if (numSecuSocial == null ) {
				msg += "<li>numéro de Securité Social</li>";
			} else {
				if (numSecuSocial.length() != 15 || numSecuSocial.matches("[0-9]+")) {
					msg += "<li>numéro de Securité Social doit contenir 15 chiffres</li>";
				}
			}
			
			msg += "</ul>";
			// code HTML ecrit dans le corps de la reponse
			resp.getWriter().write("<h1>Erreur de saisie du formulaire</h1>" + msg);

		} else {
			String matricule = "M"+collabService.listerCollaborateurs().size();
			LocalDate dateN = LocalDate.parse(dateNaissance);
			Collaborateur collab = new Collaborateur();
			String emailPro = prenom+"."+nom+"@societe.com";
			String photo = "";
			collab.setAdresse(adresse);
			collab.setDateNaissance(dateN);
			collab.setEmailPro(emailPro);
			collab.setMatricule(matricule);
			collab.setNom(nom);
			collab.setPrenom(prenom);
			collab.setNumSecuSocial(numSecuSocial);
			collab.setPhoto(photo);
			
			collabService.sauvegarderCollaborateur(collab);
			resp.sendRedirect("lister");
			
		}
		
	}

}
