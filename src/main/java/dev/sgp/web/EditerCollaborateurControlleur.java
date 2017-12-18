package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;

@WebServlet("/collaborateurs/editer")
public class EditerCollaborateurControlleur extends HttpServlet {
	/**
	 * Constante pour le service technique des collaborateurs (sauvegarde des
	 * données en mémoire)
	 */
	private final CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	/**
	 * Constante pour le service technique des Départements (sauvegarde des données
	 * en mémoire)
	 */
	private final DepartementService deptService = Constantes.DEPT_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
		// recupere la valeur d'un parametre dont le nom est collabMatricule
		String matricule = req.getParameter("collabMatricule");

		// Récupérer le collaborateur de la liste
		List<Collaborateur> collabs = collaborateurs.stream().filter(c -> c.getMatricule().equals(matricule))
				.collect(Collectors.toList());
		req.setAttribute("collaborateur", collabs.get(0));

		List<Departement> departements = deptService.listerDepartements();
		req.setAttribute("listeDepartement", departements);

		req.getRequestDispatcher("/WEB-INF/views/collab/editerCollaborateur.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Departement> departements = deptService.listerDepartements();

		// recupere la valeur d'un parametre dont le nom est collabMatricule
		String matricule = req.getParameter("cmatricule");

		// recupere la valeur d'un parametre dont le nom est civilite
		String civilite = req.getParameter("civilite");

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

		// recupere la valeur d'un parametre dont le nom est banque
		String banque = req.getParameter("banque");

		// recupere la valeur d'un parametre dont le nom est bic
		String bic = req.getParameter("bic");

		// recupere la valeur d'un parametre dont le nom est ban
		String ban = req.getParameter("ban");

		resp.setContentType("text/html");
		String msg = "";
		if (adresse == null || adresse.equals("") || departement == null
				|| departement.equals("") || intitulePoste == null || intitulePoste.equals("")) {
			resp.setStatus(400);
			msg += "<br>Les paramètres suivants sont incorrects: " + "<ul>";
			if (civilite == null || nom.equals("")) {
				msg += "<li>civilite</li>";
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
			LocalDate dateN = LocalDate.parse(dateNaissance);
			Collaborateur collab = new Collaborateur();
			String emailPro = prenom + "." + nom + "@societe.com";
			collab.setMatricule(matricule);
			collab.setAdresse(adresse);
			collab.setDateNaissance(dateN);
			collab.setEmailPro(emailPro);
			collab.setNom(nom);
			collab.setPrenom(prenom);
			collab.setNumSecuSocial(numSecuSocial);
			collab.setIntitulePoste(intitulePoste);
			collab.setCivilite(civilite);
			collab.setBanque(banque);
			collab.setBan(ban);
			collab.setBic(bic);
			if (collab.getCivilite().equals("Mme")) {
				collab.setPhoto("https://bootdey.com/img/Content/user_2.jpg");
			} else {
				collab.setPhoto("https://bootdey.com/img/Content/user_1.jpg");
			}
			collab.setDepartement((Departement) departements.stream().filter(d -> d.getNom().equals(departement))
					.collect(Collectors.toList()).get(0));
			System.out.println("checkbox: " + req.getParameter("checkboxActif"));
			if (req.getParameter("checkboxActif") == null) {
				collab.setActif(true);
			} else {
				collab.setActif(false);
			}
			collabService.modifierCollaborateur(matricule, collab);
			resp.sendRedirect("lister?choixDept=Tous");
		}

	}

}
