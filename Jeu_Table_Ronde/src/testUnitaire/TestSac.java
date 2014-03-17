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
	ObjetGraal graal, excalibur;
	Integer poids;
	
	@Before
	protected void setUp() throws Exception{
		super.setUp();
		sac = new Sac();
		graal = new ObjetGraal("Graal",1,1);
		excalibur = new ObjetGraal("Excalibur",2,1);
		sac.ajoutObjetGraal(graal);
		contenu = sac.getContenu();
		poids= sac.getPoids();
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
		assertTrue(contenu.isEmpty());
	}
	
	public void testgetPoids(){
		assertNotNull(poids);		
	}
	
	public void testsetPoids(){
		sac.setPoids(22);
		poids=sac.getPoids();
		assertSame(22,poids);
	}
	
	public void testGetContenu(){
		sac.getContenu();
		assertNotNull(contenu);
		assertTrue(contenu.contains(graal));
	}
	
	public void testSetContenu(){
		contenu.add(excalibur);
		sac.setContenu(contenu);
		assertTrue(contenu.contains(excalibur));
		assertTrue(contenu.contains(graal));
		
		
	}
	
	
	
}
