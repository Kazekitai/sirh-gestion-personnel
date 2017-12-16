package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

public class SupprimerCollaborateurControlleur  extends HttpServlet {
	/**
	 * Constante pour le service technique des collaborateurs (sauvegarde des
	 * données en mémoire)
	 */
	private final CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
		ServletException, IOException {
		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
		// recupere la valeur d'un parametre dont le nom est collabMatricule
		String matricule = req.getParameter("collabMatricule");
		
		// Supprimer le collaborateur de la liste
		List<Collaborateur> collabs =  collaborateurs.stream().filter(c -> c.getMatricule().equals(matricule)).collect(Collectors.toList());
		collaborateurs.remove(collabs.get(0));
		
		resp.sendRedirect("lister?choixDept=Tous");
	}
}
