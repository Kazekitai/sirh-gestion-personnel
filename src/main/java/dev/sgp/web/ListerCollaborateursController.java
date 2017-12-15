package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
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
 * Controlleur pour lister les collaborateurs
 * 
 * @author Sandra Le Thiec
 *
 */
public class ListerCollaborateursController extends HttpServlet {
	/**
	 * Constante pour le service technique des collaborateurs (sauvegarde des
	 * données en mémoire)
	 */
	private final CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	private final DepartementService deptService = Constantes.DEPT_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// utilisation des services 
		List<Departement> departements = deptService.listerDepartements();
		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
			// initialisation de la liste des collaborateurs si elle est vide
		if(collaborateurs.isEmpty()) {
			Collaborateur collab1 = new Collaborateur();
			collab1.setNom("César");
			collab1.setPrenom("Jules");
			collab1.setAdresse("4 rue Edith Piaf, 44800 Saint-Herblain");
			collab1.setDateNaissance(LocalDate.of(1985, 10, 14));
			collab1.setDepartement((Departement) departements.stream().filter(d -> d.getNom().equals("Ressources Humaines"))
					.collect(Collectors.toList()).get(0));
			collab1.setEmailPro("Jules.César@societe.com");
			collab1.setIntitulePoste("Directeur");
			collab1.setMatricule("M" + collaborateurs.size());
			collab1.setNumSecuSocial("123456789123456");
			collaborateurs.add(collab1);
//			collabService.sauvegarderCollaborateur(collab1);

			Collaborateur collab2 = new Collaborateur();
			collab2.setNom("Bono");
			collab2.setPrenom("Jean");
			collab2.setActif(false);
			collab2.setAdresse("4 rue Edith Piaf, 44800 Saint-Herblain");
			collab2.setDateNaissance(LocalDate.of(1985, 11, 25));
			collab2.setDepartement((Departement) departements.stream().filter(d -> d.getNom().equals("Informatique"))
					.collect(Collectors.toList()).get(0));
			collab2.setEmailPro("Jean.Bono@societe.com");
			collab2.setIntitulePoste("Développeur");
			collab2.setMatricule("M" + collaborateurs.size());
			collab2.setNumSecuSocial("123456789123456");
			collaborateurs.add(collab2);
//			collabService.sauvegarderCollaborateur(collab2);
			
		}
		
		
		
		// Tester s'il n'y a aucun filtre
		if ((req.getParameter("choixDept") == null || req.getParameter("choixDept").equals("Tous"))
				&& (req.getParameter("checkboxActif") == null || req.getParameter("checkboxActif").equals("checked"))
				&& (req.getParameter("rechercheCollab") == null || req.getParameter("rechercheCollab").isEmpty())) {
			List<Collaborateur> collaborateursSelect = collaborateurs;
			if (req.getParameter("checkboxActif") == null) {
				collaborateursSelect = collaborateurs.stream()
						.filter(c -> c.getActif() == true).collect(Collectors.toList());
				req.setAttribute("checked", "");
			}else {
				req.setAttribute("checked", "checked");
			}
			req.setAttribute("listeCollab", collaborateursSelect);
			req.setAttribute("selected", "Tous");
			System.out.println("passe");
		} else {
			// 1. filtrer le departement
			List<Collaborateur> collaborateursSelectByDept = collaborateurs;
			if (!req.getParameter("choixDept").equals("Tous")) {
				collaborateursSelectByDept = collaborateurs.stream()
						.filter(c -> c.getDepartement().getNom().equals(req.getParameter("choixDept")))
						.collect(Collectors.toList());
			}

			// 2. filtrer si la case "voir collaborateurs desactivé" est décoché
			List<Collaborateur> collaborateursSelectByActif = collaborateursSelectByDept;
			if (req.getParameter("checkboxActif") == null) {
				collaborateursSelectByActif = collaborateursSelectByDept.stream()
						.filter(c -> c.getActif() == true).collect(Collectors.toList());
				req.setAttribute("checked", "");
			}else {
				req.setAttribute("checked", "checked");
			}
			// 3. filtrer si une recherche est activé
			List<Collaborateur> collaborateursSelectByNom = collaborateursSelectByActif;
			if (req.getParameter("rechercheCollab") != null	|| !req.getParameter("rechercheCollab").isEmpty()) {
				collaborateursSelectByNom = collaborateursSelectByActif.stream()
						.filter(c -> c.getNom().startsWith(req.getParameter("rechercheCollab"))).collect(Collectors.toList());
			}

			req.setAttribute("listeCollab", collaborateursSelectByNom);
			req.setAttribute("selected", req.getParameter("choixDept"));
		}

		req.setAttribute("listeDepartement", departements);
		req.getRequestDispatcher("/WEB-INF/views/collab/listerCollaborateurs.jsp").forward(req, resp);

	}
}
