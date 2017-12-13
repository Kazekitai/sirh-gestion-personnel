package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;

/**
 * Un collaborateur
 * @author Sandra Le Thiec
 *
 */
public class Collaborateur {
	
	/* ATTRIBUTS */
	
	/**
	 * Un matricule
	 */
	private String matricule;
	
	/**
	 * Un nom
	 */
	private String nom;
	
	/**
	 * Un prénom
	 */
	private String prenom;
	
	/**
	 * Une date de naissance
	 */
	private LocalDate dateNaissance;
	
	/**
	 * Une adresse
	 */
	private String adresse;
	
	/**
	 * Un numéro de sécurité sociale
	 */
	private String numSecuSocial;
	
	/**
	 * Un email professionnel
	 */
	private String emailPro;
	
	/**
	 * L'adresse d'une photo
	 */
	private String photo;
	
	/**
	 * Une date de création
	 */
	private ZonedDateTime dateHeureCreation;
	
	/**
	 * Un attribut indiquant si le collaborateur est actif (true) ou non (false)
	 */
	private Boolean actif;
	
	
	/* CONSTRUCTEUR */
	
	/**
	 * Constructeur par défaut
	 */
	public Collaborateur() {}
	
	/* GETTERS ET SETTERS */

	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the numSecuSocial
	 */
	public String getNumSecuSocial() {
		return numSecuSocial;
	}

	/**
	 * @param numSecuSocial the numSecuSocial to set
	 */
	public void setNumSecuSocial(String numSecuSocial) {
		this.numSecuSocial = numSecuSocial;
	}

	/**
	 * @return the emailPro
	 */
	public String getEmailPro() {
		return emailPro;
	}

	/**
	 * @param emailPro the emailPro to set
	 */
	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the dateHeureCreation
	 */
	public ZonedDateTime getDateHeureCreation() {
		return dateHeureCreation;
	}

	/**
	 * @param dateHeureCreation the dateHeureCreation to set
	 */
	public void setDateHeureCreation(ZonedDateTime dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}

	/**
	 * @return the actif
	 */
	public Boolean getActif() {
		return actif;
	}

	/**
	 * @param actif the actif to set
	 */
	public void setActif(Boolean actif) {
		this.actif = actif;
	}
	
	
	
	
	

}
