package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;
import dev.sgp.entite.VisitWeb;

/**
 * Service pour les statistiques des pages
 * @author Sandra Le Thiec
 *
 */
public class StatistiqueService {
	/**
	 * Liste des visites
	 */
	List<VisitWeb> VisitWeb = new ArrayList<>();

	/**
	 * Récupérer la liste des visites 
	 * @return
	 */
	public List<VisitWeb> listerVisites() {
		return VisitWeb;
	}

	/**
	 * Sauvegarder une visite
	 * @param visit
	 */
	public void sauvegarderVisites(VisitWeb visit) {
		Integer id = new Integer(0);
		if(VisitWeb.size() > 0) {
			id = new Integer(VisitWeb.size());
		}
		visit.setId(id);
		VisitWeb.add(visit);
	}
	
	
}
