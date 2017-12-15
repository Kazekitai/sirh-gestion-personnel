package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;
import dev.sgp.entite.Collaborateur;
import dev.sgp.util.Constantes;

public class CollaborateurService {
	/**
	 * Liste des collaborateurs
	 */
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();
	
	/**
	 * Constante pour le service technique des Départements (sauvegarde des données
	 * en mémoire)
	 */
	private final DepartementService deptService = Constantes.DEPT_SERVICE;


	public List<Collaborateur> listerCollaborateurs() {		
		return listeCollaborateurs;
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {
		listeCollaborateurs.add(collab);
	}

}
