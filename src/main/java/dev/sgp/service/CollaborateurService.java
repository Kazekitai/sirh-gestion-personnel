package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import dev.sgp.entite.Collaborateur;

public class CollaborateurService {
	/**
	 * Liste des collaborateurs
	 */
	List<Collaborateur> listeCollaborateurs = new ArrayList<>();
	
	public List<Collaborateur> listerCollaborateurs() {		
		return listeCollaborateurs;
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {
		listeCollaborateurs.add(collab);
	}
	
	public void modifierCollaborateur(String matricule, Collaborateur collab) {
		// Récupérer l'index du collaborateur à modifier par son matricule
		List<Collaborateur> collabs = listeCollaborateurs.stream().filter(c -> c.getMatricule().equals(matricule))
				.collect(Collectors.toList());
		int index = listeCollaborateurs.indexOf(collabs.get(0));
		
		// modifier le collaborateur
		listeCollaborateurs.set(index,collab);
	}

}
