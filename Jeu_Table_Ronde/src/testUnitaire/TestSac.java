package testUnitaire;

import junit.framework.TestCase;
import model.ObjetGraal;
import model.Sac;

import org.junit.Before;
import org.junit.Test;

public class TestSac extends TestCase {

	Sac sac;
	
	@Before
	protected void setUp() throws Exception{
		super.setUp();
		// erreur: constructeur en privé donc pas possible de tester
		sac = new Sac();
		
	}
	@Test
	public void testConstructeur(){
		assertNotNull(sac);
	}
}
