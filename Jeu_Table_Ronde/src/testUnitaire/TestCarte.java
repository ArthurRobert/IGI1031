package testUnitaire;

import java.util.ArrayList;

import junit.framework.TestCase;
import model.Chevalier;
import model.ChevalierJoueur;
import model.ChevalierOrdi;
import model.ObjetGraal;

import org.junit.Before;
import org.junit.Test;

import vue.Carte;
import vue.CartePanel;

public class TestCarte extends TestCase{
	
	float ratio = 20;
	int nbCaseX = 10;
	int nbCaseY = 15;
	Carte carte, carte2;
	CartePanel panel;
	ArrayList<Chevalier> chevalier_vector = new ArrayList<Chevalier>();
	ArrayList<Chevalier> chevalier_vector2 = new ArrayList<Chevalier>();

	
	@Before
	protected void setUp() throws Exception{
		super.setUp();
		Chevalier c1 = new ChevalierJoueur("Arthur");
		Chevalier c3 = new ChevalierOrdi("AAA");
		chevalier_vector.add(c1);
		chevalier_vector2.add(c3);
		carte = Carte.getInstance(nbCaseX, nbCaseY, ratio, chevalier_vector);
		System.out.println(chevalier_vector );
		panel = new  CartePanel(ratio, nbCaseX, nbCaseY);
	}
	
	@Test
	// Constructeur en privée, singleton
	public void testCarteGetInstance(){
		assertNotNull(carte);
	}
	
	public void testIsCreated(){
		assertTrue(carte.isCreated());
	}
	
	//test des getteurs et setteurs
	public void testGetCaseX(){
		int x = carte.getNbCaseX();
		assertNotNull(x);
		assertEquals(x,10);
	}
	
	public void testNbCaseY(){
		int y = carte.getNbCaseY();
		assertNotNull(y);
		assertEquals(y,15);
	}
	
	public void testGetRatio(){
		float r = carte.getRatio();
		assertNotNull(r);
		assertEquals(r, ratio);
	}
	
	public void testSetRatio(){
		float r = 50;
		carte.setRatio(50);
		assertEquals(carte.getRatio(),r);	
	}
	
	public void testGetTabChevalier(){
		//carte.setTabChevalier(chevalier_vector);
		System.out.println("a" + chevalier_vector);
		assertSame(carte.getTabChevalier(),chevalier_vector);
	}
	
	public void testSetTablChevalier(){
		carte.setTabChevalier(chevalier_vector2);
		assertEquals(carte.getTabChevalier(), chevalier_vector2);
	}
	
	public void testGetPanel(){
		assertSame(carte.getCartePanel(),carte.cartePanel);
	}
	
	public void testSetpanel(){
		carte.setCartePanel(panel);
		assertSame(carte.getCartePanel(), panel);
	}
	
	
}
