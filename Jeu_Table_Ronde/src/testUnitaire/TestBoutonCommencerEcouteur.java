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
	BoutonCommencerEcouteur ecouteur;
		
		@Before
		protected void setUp() throws Exception{
			super.setUp();
			ecouteur= new BoutonCommencerEcouteur( ratioTf, largeurTf,
					hauteurTf, joueur1, joueur2,
					joueur3, joueur4, boutonOrdi1,
					boutonOrdi2, boutonOrdi3,
					boutonOrdi4, o);
			
		}
		
		@Test
		public void testConstructeur(){
			assertNotNull(ecouteur);
		}
		




}
