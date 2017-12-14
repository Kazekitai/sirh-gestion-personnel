package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dev.sgp.entite.VisitWeb;
import dev.sgp.service.StatistiqueService;
import dev.sgp.util.Constantes;

/**
 * Controlleur pour Récupérer les statistiques du site
 * @author Sandra Le Thiec
 *
 */
public class StatistiquesSiteControlleur  extends HttpServlet {
	/**
	 * Constante pour le service technique des collaborateurs (sauvegarde des données en mémoire)
	 */
	private final StatistiqueService statService = Constantes.STAT_SERVICE;
	
	/**
	 * Faire une requête de type GET
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// utilisation du service STATIC_SERVICE
		List<VisitWeb> visites = statService.listerVisites();
		req.setAttribute("listeVisites",visites);
		req.getRequestDispatcher("/WEB-INF/views/collab/statistiques.jsp").forward(req, resp);
	}
	
	
	

}