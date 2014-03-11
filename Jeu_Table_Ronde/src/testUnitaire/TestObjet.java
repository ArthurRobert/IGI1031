package testUnitaire;

import junit.framework.TestCase;
import model.Objet;
import model.ObjetGraal;

import org.junit.Before;
import org.junit.Test;

public class TestObjet extends TestCase {

	Objet graal;
	
	@Before
	protected void setUp() throws Exception{
		super.setUp();
		graal = new ObjetGraal("nom", 42, 0);
		
	}
	@Test
	public void testConstructeur(){
		assertNotNull(graal);
	}
	public void testNbVie(){
		assertSame(0,graal.getNbVie());
		graal.setNbVie(2);
		assertSame(2, graal.getNbVie());
	}
	public void testType(){
		assertSame("nom",graal.getType());
		graal.setType("type");
		assertSame("type",graal.getType());
	}
}
