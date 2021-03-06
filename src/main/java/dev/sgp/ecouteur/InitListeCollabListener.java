package dev.sgp.ecouteur;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;

/**
 * Ecouteur pour initialiser la liste des collaborateurs au lancement de l'application
 * @author Sandra Le Thiec
 *
 */
@WebListener
public class InitListeCollabListener implements ServletContextListener {
	
	/**
	 * Constante pour le service technique des collaborateurs (sauvegarde des
	 * données en mémoire)
	 */
	private final CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	
	/**
	 * Constante pour le service technique des départements (sauvegarde des
	 * données en mémoire)
	 */
	private final DepartementService deptService = Constantes.DEPT_SERVICE;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext contexte = event.getServletContext();
		
		// Initialiser la liste des collaborateurs
		List<Departement> departements = deptService.listerDepartements();
		List<Collaborateur> collaborateurs = collabService.listerCollaborateurs();
		Collaborateur collab1 = new Collaborateur();
		collab1.setCivilite("Mr");
		collab1.setNom("César");
		collab1.setPrenom("Jules");
		collab1.setAdresse("4 rue Edith Piaf, 44800 Saint-Herblain");
		collab1.setDateNaissance(LocalDate.of(1985, 10, 14));
		collab1.setDepartement((Departement) departements.stream().filter(d -> d.getNom().equals("Ressources Humaines"))
				.collect(Collectors.toList()).get(0));
		collab1.setEmailPro("Jules.César@societe.com");
		collab1.setIntitulePoste("Directeur");
		collab1.setMatricule("M" + collaborateurs.size());
		collab1.setNumSecuSocial("123456789123456");
		collab1.setPhoto("https://bootdey.com/img/Content/user_1.jpg");
		collaborateurs.add(collab1);

		Collaborateur collab2 = new Collaborateur();
		collab2.setNom("Bono");
		collab2.setPrenom("Jean");
		collab2.setActif(false);
		collab2.setAdresse("4 rue Edith Piaf, 44800 Saint-Herblain");
		collab2.setDateNaissance(LocalDate.of(1985, 11, 25));
		collab2.setDepartement((Departement) departements.stream().filter(d -> d.getNom().equals("Informatique"))
				.collect(Collectors.toList()).get(0));
		collab2.setEmailPro("Jean.Bono@societe.com");
		collab2.setIntitulePoste("Développeur");
		collab2.setMatricule("M" + collaborateurs.size());
		collab2.setNumSecuSocial("123456789123456");
		collab2.setPhoto("https://bootdey.com/img/Content/user_1.jpg");
		collaborateurs.add(collab2);
		
		Collaborateur collab3 = new Collaborateur();
		collab3.setCivilite("Mme");
		collab3.setNom("Smith");
		collab3.setPrenom("Lucie");
		collab3.setActif(true);
		collab3.setAdresse("4 rue Edith Piaf, 44800 Saint-Herblain");
		collab3.setDateNaissance(LocalDate.of(1980, 11, 01));
		collab3.setDepartement((Departement) departements.stream().filter(d -> d.getNom().equals("Informatique"))
				.collect(Collectors.toList()).get(0));
		collab3.setEmailPro("Lucie.Smith@societe.com");
		collab3.setIntitulePoste("Développeuse");
		collab3.setMatricule("M" + collaborateurs.size());
		collab3.setNumSecuSocial("123456789123456");
		collab3.setPhoto("https://bootdey.com/img/Content/user_2.jpg");
		collaborateurs.add(collab3);
		
		Collaborateur collab4 = new Collaborateur();
		collab4.setCivilite("Mme");
		collab4.setNom("Sim");
		collab4.setPrenom("Sophie");
		collab4.setActif(false);
		collab4.setAdresse("4 rue Edith Piaf, 44800 Saint-Herblain");
		collab4.setDateNaissance(LocalDate.of(1985, 06, 12));
		collab4.setDepartement((Departement) departements.stream().filter(d -> d.getNom().equals("Comptabilié"))
				.collect(Collectors.toList()).get(0));
		collab4.setEmailPro("Sophie.Sim@societe.com");
		collab4.setIntitulePoste("Secrétaire");
		collab4.setMatricule("M" + collaborateurs.size());
		collab4.setNumSecuSocial("123456789123456");
		collaborateurs.add(collab4);
		collab4.setPhoto("https://bootdey.com/img/Content/user_2.jpg");
		
		contexte.setAttribute("ListeCollaborateur", collaborateurs);
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {		
		
	}

}
