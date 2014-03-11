package testUnitaire;

import junit.framework.TestCase;
import model.Chevalier;
import model.ChevalierJoueur;
import model.Sac;

import org.junit.Before;
import org.junit.Test;

public class TestChevalierJoueur extends TestCase {

	private Chevalier joueur1;
	private Sac sac;
	
	@Before
	protected void setUp() throws Exception{
		super.setUp();
		joueur1 = new ChevalierJoueur("Arthur");
		sac = joueur1.getSacChevalier();

		
	}
	
	public void testChevalierJoueur() throws Exception {
		assertNotNull(joueur1);


	}
		
	public void testSac(){
		assertNotNull(sac);
		
	}

}
