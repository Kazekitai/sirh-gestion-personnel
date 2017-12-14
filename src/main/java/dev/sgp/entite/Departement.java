package dev.sgp.entite;

/**
 * Un département
 * @author Sandra Le Thiec
 *
 */
public class Departement {
	
	/* ATTRIBUTS */
	
	/**
	 * Un identifiant
	 */
	private int id;
	
	/**
	 * Nom du département
	 */
	private String Nom;
	
	/* CONSTRUCTEURS */
	/**
	 * Constructeur par défaut
	 */
	public Departement() {
		
	}
	
	public Departement(int id, String nom) {
			this.setId(id);
			this.setNom(nom);
	}

	
	/* GETTERS ET SETTERS */
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return Nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		Nom = nom;
	}
	
	
	

}
