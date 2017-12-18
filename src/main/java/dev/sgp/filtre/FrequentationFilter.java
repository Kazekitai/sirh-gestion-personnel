package dev.sgp.filtre;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import dev.sgp.entite.VisitWeb;
import dev.sgp.service.StatistiqueService;
import dev.sgp.util.Constantes;

/**
 * Filtre pour la fréquentation des pages web
 * @author Sandra Le Thiec
 *
 */
@WebFilter(urlPatterns = { "/collaborateurs/*" },
description = "excution time filter")
public class FrequentationFilter implements Filter {
	/**
	 * Configuration du filtre
	 */
	private FilterConfig config = null;
	
	/**
	 * Service des statistiques
	 */
	private final StatistiqueService statService = Constantes.STAT_SERVICE;

	/**
	 * Intitialiser le filtre
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = filterConfig;
		config.getServletContext().log("TimerFilter initialized");
	}

	/**
	 * Exécuter le filtre
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		long before = System.currentTimeMillis();
		chain.doFilter(request, response);
		long after = System.currentTimeMillis();
		String path = ((HttpServletRequest) request).getRequestURI();
		VisitWeb visit = new VisitWeb();
		visit.setChemin(path);
		int tempsExecution = (int) (after - before);
		visit.setTempsExecution(tempsExecution);
		statService.sauvegarderVisites(visit);
		config.getServletContext().log(path + " : " + (after - before));
	
	}

	/**
	 * Détruire le filtre
	 */
	@Override
	public void destroy() {}

}
