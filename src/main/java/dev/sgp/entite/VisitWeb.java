package dev.sgp.entite;

/**
 * Informations de visite d'une page
 * @author Sandra Le Thiec
 *
 */
public class VisitWeb {
	
	/* ATTRIBUTS */
	
	/**
	 * Un identifiant
	 */
	private Integer id;
	
	/**
	 * Chemin de la page visiter
	 */
	String chemin;
	
	/**
	 * Temps de visite sur la page web
	 */
	Integer tempsExecution;
	
	/* CONTROLEUR */
	/**
	 * Constructeur par défaut
	 */
	public VisitWeb() {}
	
	/* GETTERS ET SETTERS */

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the chemin
	 */
	public String getChemin() {
		return chemin;
	}

	/**
	 * @param chemin the chemin to set
	 */
	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	/**
	 * @return the tempsExecution
	 */
	public Integer getTempsExecution() {
		return tempsExecution;
	}

	/**
	 * @param tempsExecution the tempsExecution to set
	 */
	public void setTempsExecution(Integer tempsExecution) {
		this.tempsExecution = tempsExecution;
	}
	
	
	

}
