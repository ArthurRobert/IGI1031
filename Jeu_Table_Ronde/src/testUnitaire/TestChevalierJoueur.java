package testUnitaire;

import junit.framework.TestCase;
import model.Chateau;
import model.Chevalier;
import model.ChevalierJoueur;
import model.Mouvement;
import model.ObjetGraal;
import model.Sac;

import org.junit.Before;
import org.junit.Test;

public class TestChevalierJoueur extends TestCase {

	private Chevalier joueur1;
	private Sac sac;
	private ObjetGraal excalibur;
	private Integer niveauDeVie;
	
	@Before
	protected void setUp() throws Exception{
		super.setUp();
		joueur1 = new ChevalierJoueur("Arthur");
		sac = joueur1.getSacChevalier();
		excalibur = new ObjetGraal("Excalibur", 10, 11);
		// erreur sur trouverObjet
	//	joueur1.trouverObjet(excalibur);
		joueur1.setNivVie(0);
		niveauDeVie = joueur1.getNivVie();
		
	}
	
	@Test
	public void testChevalierJoueur() throws Exception {
		assertNotNull(joueur1);
	}
		
	//erreur lors du test
	public void testSac(){
		assertNotNull(sac);
	}
	
	public void testObjet(){
		assertNotNull(excalibur);
	}
	public void testGetSacChevalier(){
		assertSame(excalibur,joueur1.getSacChevalier());
	}
	//test des getteurs et setteurs
	public void testNiveauDeVie(){
		assertNotNull(niveauDeVie);
		assertSame("la vie doit etre de 0",0, joueur1.getNivVie());
	}
	public void testPositionX(){
		joueur1.setPositionX(1);
		assertSame(1, joueur1.getPositionX());
	}
	public void testPositionY(){
		joueur1.setPositionY(1);
		assertSame(1, joueur1.getPositionY());
	}
	public void testNom(){
		assertSame("Arthur",joueur1.getNom());
		joueur1.setNom("Perceval");
		assertSame("Perceval",joueur1.getNom());
	}
	public void testType(){
		joueur1.setType("pc");
		assertSame("pc", joueur1.getType());
	}
	// A implementer
	public void testMouvement(){
		//test get/set mouvement d'un chevalier
	}
}
