package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.sgp.entite.VisitWeb;
import dev.sgp.service.StatistiqueService;
import dev.sgp.util.Constantes;

/**
 * Controlleur pour Récupérer les statistiques du site
 * @author Sandra Le Thiec
 *
 */
public class StatistiquesSiteControlleur  extends HttpServlet {
	private final Logger LOG = LoggerFactory.getLogger(StatistiquesSiteControlleur.class);
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
//		visites.stream().collect(Collectors.summarizingInt(VisitWeb::getTempsExecution)).getCount();
//		visites.stream().collect(Collectors.summarizingInt(VisitWeb::getTempsExecution)).getMin();
//		visites.stream().collect(Collectors.summarizingInt(VisitWeb::getTempsExecution)).getMax();
//		visites.stream().collect(Collectors.summarizingInt(VisitWeb::getTempsExecution)).getAverage();
		req.getRequestDispatcher("/WEB-INF/views/collab/statistiques.jsp").forward(req, resp);
	}
	
	
	

}
