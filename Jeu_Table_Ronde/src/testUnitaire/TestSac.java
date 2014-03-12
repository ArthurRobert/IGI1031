package testUnitaire;

import java.util.ArrayList;

import junit.framework.TestCase;
import model.ObjetGraal;
import model.Sac;

import org.junit.Before;
import org.junit.Test;

public class TestSac extends TestCase {

	Sac sac;
	ArrayList<ObjetGraal> contenu;
	ObjetGraal graal;
	
	@Before
	protected void setUp() throws Exception{
		super.setUp();
		sac = new Sac();
		graal = new ObjetGraal("Graal",1,1);
		sac.ajoutObjetGraal(graal);
		contenu = sac.getContenu();

		
	}
	@Test
	public void testConstructeur(){
		assertNotNull(sac);
	}
	
	public void testAjoutObjetGraal(){
		assertNotNull(contenu);
		//System.out.println(contenu.contains(graal));
		assertSame(graal,contenu.get(0));
	}
	
	public void testViderSac(){
		sac.viderSac();
		contenu = sac.getContenu();
		assertNull(contenu);
	}
	
	
	
	
}
