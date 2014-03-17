package testUnitaire;

import junit.framework.TestCase;
import model.Objet;

import org.junit.Before;
import org.junit.Test;

import vue.Case;

public class TestCaseClasse extends TestCase{
	
	Case case1;
	Objet element;
	String numeroCase;
	
	@Before
	protected void setUp() throws Exception{
		super.setUp();
		case1 = new Case();
	}
	
	@Test
	// Constructeur 
	public void testCase(){
		assertNotNull(case1);
	}
	
	public void testGetElement(){
		assertNull(case1.getElement());
	}
	
	public void testSetElement(){
		case1.setElement(element);
		assertSame(case1.getElement(),element);
	}
	
	public void testGetNumeroCase(){
		assertNull(case1.getNumeroCase());
	}
	
	public void testSetNumeroCase(){
		case1.setNumeroCase(numeroCase);
		assertSame(case1.getNumeroCase(),numeroCase);
	}
	
}