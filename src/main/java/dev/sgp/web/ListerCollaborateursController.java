package dev.sgp.web;

import java.io.IOException;
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

/**
 * Controlleur pour lister les collaborateurs
 * 
 * @author Sandra Le Thiec
 *
 */
@WebServlet("/collaborateurs/lister")
public class ListerCollaborateursController extends HttpServlet {

	/**
	 * Constante pour le service technique des collaborateurs (sauvegarde des
	 * données en mémoire)
	 */
	private final CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	
	/**
	 * Constante pour le service technique des départements (sauvegarde des
	 * données en mémoire)
	 */
	private final DepartementService deptService = Constantes.DEPT_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// utilisation des services 
		List<Departement> departements = deptService.listerDepartements();
		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
		
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
