package testUnitaire;

import vue.CartePanel;
import controleur.ClickBoutonEcouteur;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class TestClickBoutonEcouteur extends TestCase {
	
	CartePanel cartePan;
	ClickBoutonEcouteur ecouteur;
	
	@Before
	protected void setUp() throws Exception{
		super.setUp();
		ecouteur = new ClickBoutonEcouteur(cartePan);
		
	}
	
	@Test
	public void testConstructeur(){
		assertNotNull(ecouteur);
	}

}
