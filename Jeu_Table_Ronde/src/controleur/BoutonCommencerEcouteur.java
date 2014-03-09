package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Ecouteur pour le bouton demarrer de nouvelle partie
 * 
 * */
public class BoutonCommencerEcouteur implements ActionListener {

	private JTextField ratioTf, largeurTf, hauteurTf, joueur1, joueur2, joueur3, joueur4;
	
	private JRadioButton boutonHumain1, boutonHumain2, boutonHumain3, boutonHumain4, boutonOrdi1, boutonOrdi2, boutonOrdi3, boutonOrdi4 ;


	/**
	 * Constructeur
	 * 
	 * @param ratioTf
	 * @param largeurTf
	 * @param hauteurTf
	 * @param joueur1
	 * @param joueur2
	 * @param joueur3
	 * @param joueur4
	 * @param boutonHumain1
	 * @param boutonHumain2
	 * @param boutonHumain3
	 * @param boutonHumain4
	 * @param boutonOrdi1
	 * @param boutonOrdi2
	 * @param boutonOrdi3
	 * @param boutonOrdi4
	 */
	public BoutonCommencerEcouteur(JTextField ratioTf, JTextField largeurTf,
			JTextField hauteurTf, JTextField joueur1, JTextField joueur2,
			JTextField joueur3, JTextField joueur4, JRadioButton boutonHumain1,
			JRadioButton boutonHumain2, JRadioButton boutonHumain3,
			JRadioButton boutonHumain4, JRadioButton boutonOrdi1,
			JRadioButton boutonOrdi2, JRadioButton boutonOrdi3,
			JRadioButton boutonOrdi4) {
		super();
		this.ratioTf = ratioTf;
		this.largeurTf = largeurTf;
		this.hauteurTf = hauteurTf;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.joueur3 = joueur3;
		this.joueur4 = joueur4;
		this.boutonHumain1 = boutonHumain1;
		this.boutonHumain2 = boutonHumain2;
		this.boutonHumain3 = boutonHumain3;
		this.boutonHumain4 = boutonHumain4;
		this.boutonOrdi1 = boutonOrdi1;
		this.boutonOrdi2 = boutonOrdi2;
		this.boutonOrdi3 = boutonOrdi3;
		this.boutonOrdi4 = boutonOrdi4;
	}

	/**
	 * Actions a effectuer :
	 * 
	 * Verification des formats des champs, de leur valeur
	 */
	public void actionPerformed(ActionEvent arg0) 
	{
		
	}
	
	/**
	 * retourne le ratio s'il est correct, -1 sinon
	 */
	private int isRatioOk(String ratioTxt) {
		//critère pour le ratio à déterminer
		
		try 
		{		
			return Integer.parseInt(ratioTxt);			
		} 
		catch (NumberFormatException e) 
		{
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * retourne si le nom est correct ou non
	 * Le nom doit etre rempli et pas trop plus de 30 caratères
	 */
	private boolean isPlayerNameOk(String joueur) {
		
		if (joueur.isEmpty() || joueur==null || joueur.length()>30) {
			return false;
		}
		else {
			return true;
		}
	}
	
	/**
	 * retourne la dimension si elle est correcte, -1 sinon
	 * elle doit etre comprise entre 2 et 30 (a modifier si besoin
	 */
	private int isDimensionOk(String dimTxt) {
		
		int dimension;
		
		try 
		{		
			 dimension =Integer.parseInt(dimTxt);	
		} 
		catch (NumberFormatException e) 
		{
			e.printStackTrace();
			return -1;
		}
		
		if (dimension<2 ||dimension > 30) {
			return -1;
		}
		else {
			return dimension;
		}
		
	}

}
