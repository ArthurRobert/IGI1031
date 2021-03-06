package testUnitaire;

import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

import junit.framework.TestCase;
import model.Chevalier;

import org.junit.Before;
import org.junit.Test;

import controleur.BoutonCommencerEcouteur;

public class TestBoutonCommencerEcouteur extends TestCase{

	private JTextField largeurTf, hauteurTf, joueur1, joueur2, joueur3, joueur4;
	private JSlider ratioTf;
	private JRadioButton boutonOrdi1, boutonOrdi2, boutonOrdi3, boutonOrdi4 ;
	private Object o;
	private ArrayList<Chevalier> chevalier_vector = new ArrayList<Chevalier>();
	ArrayList<String> joueurs = new ArrayList<String>();
	
	BoutonCommencerEcouteur ecouteur;
	Boolean bool;
	String dimTxt;
		
		@Before
		protected void setUp() throws Exception{
			super.setUp();
			ecouteur= new BoutonCommencerEcouteur( ratioTf, largeurTf,
					hauteurTf, joueur1, joueur2,
					joueur3, joueur4, boutonOrdi1,
					boutonOrdi2, boutonOrdi3,
					boutonOrdi4, o);
			joueurs.add("joueur1");
			joueurs.add("joueur2");
			joueurs.add("joueur3");
			joueurs.add("joueur4");
			dimTxt="10";

		}
		
		@Test
		public void testConstructeur(){
			assertNotNull(ecouteur);
		}
		
		public void testIsPlayerNameOk(){
			//passage de la méthode en public pour les tests
			//bool = ecouteur.isPlayerNameOk(joueurs);
			//assertTrue(bool);
		}
		
		public void testIsPlayerNameOkFalse(){
			//passage de la méthode en public pour les tests
			//joueurs.add("joueur1");
			//bool = ecouteur.isPlayerNameOk(joueurs);
			//assertFalse(bool);
		}

		public void testIsDimensionOk(){
			//passage de la méthode en public pour les tests
			//int a=ecouteur.isDimensionOk(dimTxt);
			//assertSame(a,10);
		}




}
