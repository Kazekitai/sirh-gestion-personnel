package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;

/**
 * Controlleur pour ajouter un collaborateur
 * @author Sandra Le Thiec
 *
 */
public class AjouterCollaborateurControlleur extends HttpServlet {
	/**
	 * Constante pour le service technique des collaborateurs (sauvegarde des données en mémoire)
	 */
	private final CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	
	/**
	 * Constante pour le service technique des Départements (sauvegarde des données en mémoire)
	 */
	private final DepartementService deptService = Constantes.DEPT_SERVICE;
	
	/**
	 * Faire une requête de type GET
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// utilisation du service COLLAB_SERVICE
		List<Departement> departements = deptService.listerDepartements();
		req.setAttribute("listeDepartement",departements);
		req.getRequestDispatcher("/WEB-INF/views/collab/ajouterCollaborateur.jsp").forward(req, resp);
	}


	/**
	 * Faire une requête de type POST
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Departement> departements = deptService.listerDepartements();
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
		
		// recupere la valeur d'un parametre dont le nom est departement
				String departement = req.getParameter("departement");
				
		// recupere la valeur d'un parametre dont le nom est intitulePoste
		String intitulePoste = req.getParameter("intitulePoste");

		resp.setContentType("text/html");
		String msg = "";
		if (numSecuSocial == null || numSecuSocial.equals("") || numSecuSocial.length() != 15 || !numSecuSocial.matches("[0-9]+") 
				|| nom == null || nom.equals("") || prenom == null || prenom.equals("") || dateNaissance == null || dateNaissance.equals("") 
				|| adresse == null || adresse.equals("") || departement == null || departement.equals("") 
				||  intitulePoste == null || intitulePoste.equals("") ) {
			resp.setStatus(400);
			msg += "<br>Les paramètres suivants sont incorrects: " + "<ul>";
			if (nom == null || nom.equals("")) {
				msg += "<li>nom</li>";
			}
			if (prenom == null || prenom.equals("")) {
				msg += "<li>prenom</li>";
			}
			if (dateNaissance == null || dateNaissance.equals("")) {
				msg += "<li>date de naissance</li>";
			}
			if (numSecuSocial == null || numSecuSocial.equals("")) {
				msg += "<li>numéro de Securité Social</li>";
			} else {
				if (numSecuSocial.length() != 15) {
					msg += "<li>numéro de Securité Social doit contenir 15 chiffres</li>";
				} else if (!numSecuSocial.matches("[0-9]+")) {
					msg += "<li>numéro de Securité Social doit contenir 15 chiffres</li>";
				}
				
			}
			if (departement == null || departement.equals("")) {
				msg += "<li>departement</li>";
			}
			if (intitulePoste == null || intitulePoste.equals("")) {
				msg += "<li>fonction</li>";
			}
			
			msg += "</ul>";
			// code HTML ecrit dans le corps de la reponse
			resp.getWriter().write("<h1>Erreur de saisie du formulaire</h1>" + msg);
			

		} else {
			String matricule = "M"+collabService.listerCollaborateurs().size();
			LocalDate dateN = LocalDate.parse(dateNaissance);
			Collaborateur collab = new Collaborateur();
			String emailPro = prenom+"."+nom+"@societe.com";
			collab.setAdresse(adresse);
			collab.setDateNaissance(dateN);
			collab.setEmailPro(emailPro);
			collab.setMatricule(matricule);
			collab.setNom(nom);
			collab.setPrenom(prenom);
			collab.setNumSecuSocial(numSecuSocial);
			collab.setIntitulePoste(intitulePoste);
			collab.setDepartement((Departement) departements.stream().filter(d -> d.getNom().equals(departement)).collect(Collectors.toList()).get(0));
			
			collabService.sauvegarderCollaborateur(collab);
			resp.sendRedirect("lister?choixDept=Tous");
			
			
			
		}
		
	}

}
