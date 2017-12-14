package dev.sgp.util;

import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.service.StatistiqueService;

/**
 * Interface contenant les constantes de l'applications
 * @author Sandra Le Thiec
 *
 */
public interface Constantes {
	/**
	 * Service pour les collaborateurs
	 */
	CollaborateurService COLLAB_SERVICE = new CollaborateurService();
	
	/**
	 * Service pour les départements
	 */
	DepartementService DEPT_SERVICE = new DepartementService();
	
	/**
	 * Service pour les statistiques de visite
	 */
	StatistiqueService STAT_SERVICE = new StatistiqueService();

}
