package dev.sgp.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dev.sgp.entite.VisitWeb;
import dev.sgp.service.StatistiqueService;
import dev.sgp.util.Constantes;

/**
 * Controlleur pour Récupérer les statistiques du site
 * 
 * @author Sandra Le Thiec
 *
 */
public class StatistiquesSiteControlleur extends HttpServlet {
	private final Logger LOG = LoggerFactory.getLogger(StatistiquesSiteControlleur.class);
	/**
	 * Constante pour le service technique des collaborateurs (sauvegarde des
	 * données en mémoire)
	 */
	private final StatistiqueService statService = Constantes.STAT_SERVICE;

	/**
	 * Faire une requête de type GET
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// utilisation du service STATIC_SERVICE
		List<VisitWeb> visites = statService.listerVisites();
		HashMap<String, List<VisitWeb>> pagesVisite = (HashMap<String, List<VisitWeb>>) visites.stream()
				.collect(Collectors.groupingBy(VisitWeb::getChemin, Collectors.toList()));
		
		List<JSONObject> statObject = new ArrayList<>();
		if (pagesVisite != null) {
			
			Set cles = pagesVisite.keySet();
			Iterator it = cles.iterator();
			while (it.hasNext()) {
				String cle = (String) it.next(); // tu peux typer plus finement ici
				List<VisitWeb> valeur = pagesVisite.get(cle); // tu peux typer plus finement ici
				JSONObject json = new JSONObject();
				json.put("chemin", cle);
				json.put("nbVisites", valeur.stream().count());
				json.put("min", valeur.stream().collect(Collectors.summarizingInt(VisitWeb::getTempsExecution)).getMin());
				json.put("max", valeur.stream().collect(Collectors.summarizingInt(VisitWeb::getTempsExecution)).getMax());
				json.put("moy", valeur.stream().collect(Collectors.summarizingInt(VisitWeb::getTempsExecution)).getAverage());
				statObject.add(json);				
			}
			
		}
		req.setAttribute("statObject", statObject);
		req.getRequestDispatcher("/WEB-INF/views/collab/statistiques.jsp").forward(req, resp);
	}

}
