package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

import vue.Carte;

import model.Chevalier;
import model.FactoryChevalier;

/**
 * Ecouteur pour le bouton demarrer de nouvelle partie
 * 
 * */
public class BoutonCommencerEcouteur implements ActionListener {

	private JTextField ratioTf, largeurTf, hauteurTf, joueur1, joueur2, joueur3, joueur4;
	
	private JRadioButton boutonOrdi1, boutonOrdi2, boutonOrdi3, boutonOrdi4 ;

	private ArrayList<Chevalier> chevalier_vector = new ArrayList<Chevalier>();
	
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
	 * @param boutonOrdi1
	 * @param boutonOrdi2
	 * @param boutonOrdi3
	 * @param boutonOrdi4
	 */
	public BoutonCommencerEcouteur(JTextField ratioTf, JTextField largeurTf,
			JTextField hauteurTf, JTextField joueur1, JTextField joueur2,
			JTextField joueur3, JTextField joueur4, JRadioButton boutonOrdi1,
			JRadioButton boutonOrdi2, JRadioButton boutonOrdi3,
			JRadioButton boutonOrdi4/*, ArrayList<Chevalier> listChevalier*/) {
		
		super();
		this.ratioTf = ratioTf;
		this.largeurTf = largeurTf;
		this.hauteurTf = hauteurTf;
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.joueur3 = joueur3;
		this.joueur4 = joueur4;
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
		boolean conditionOk = true;
		
		/**
		 * Tests du type d'utilisateur
		 */
	
		
		/**
		 * Vérification du nom des joueurs
		 */	
		//obtention des noms des joueurs
		String[] joueursNames = {joueur1.getText(), joueur2.getText(), joueur3.getText(), joueur4.getText()};

		//test du nom des joueurs
		if (isPlayerNameOk(joueursNames))
		{
			
		
		//Click on boutonOrdi1
		if (boutonOrdi1.isSelected()) {
			//notifier que le joueur 1 sera dirigé par l'ordi
			chevalier_vector.add(FactoryChevalier.addChevalier(joueur1.getText(), "ordi"));
			System.out.println(joueur1.getText() + " dirigé par l'ordi !");
			
		}else {
			//notifier que le joueur 1 sera dirigé par un utilisateur
			chevalier_vector.add(FactoryChevalier.addChevalier(joueur1.getText(), "joueur"));
			System.out.println(joueur1.getText() + " dirigé par un joueur !");
		}
		
		//Click on boutonOrdi2
		if (boutonOrdi2.isSelected()) {
			//notifier que le joueur 2 sera dirigé par l'ordi
			chevalier_vector.add(FactoryChevalier.addChevalier(joueur2.getText(), "ordi"));
			System.out.println(joueur2.getText() + " dirigé par l'ordi !");
		}else {
			//notifier que le joueur 2 sera dirigé par un utilisateur
			chevalier_vector.add(FactoryChevalier.addChevalier(joueur2.getText(), "joueur"));
			System.out.println(joueur2.getText() + " dirigé par un joueur !");
		}
		
		//Click on boutonOrdi3
		if (boutonOrdi3.isSelected()) {
			//notifier que le joueur 3 sera dirigé par l'ordi
			chevalier_vector.add(FactoryChevalier.addChevalier(joueur3.getText(), "ordi"));
			System.out.println(joueur3.getText() + " dirigé par l'ordi !");
		}else {
			//notifier que le joueur 3 sera dirigé par un utilisateur
			chevalier_vector.add(FactoryChevalier.addChevalier(joueur3.getText(), "joueur"));
			System.out.println(joueur3.getText() + " dirigé par un joueur !");
		}
		
		//Click on boutonOrdi4
		if (boutonOrdi4.isSelected()) {
			//notifier que le joueur 4 sera dirigé par l'ordi
			chevalier_vector.add(FactoryChevalier.addChevalier(joueur4.getText(), "ordi"));
			System.out.println(joueur4.getText() + " dirigé par l'ordi !");
		}else {
			//notifier que le joueur 4 sera dirigé par un utilisateur
			chevalier_vector.add(FactoryChevalier.addChevalier(joueur4.getText(), "joueur"));
			System.out.println(joueur4.getText() + " dirigé par un joueur !");
		}

			//attribuer les noms des joueurs
			
		}
		else {
			//message d'erreur
			System.out.println("Erreur de nom de joueur");
			conditionOk = false;
		}
		
		
		/**
		 * vérification des dimensions
		 */
		//récupération
		int largeur = isDimensionOk(largeurTf.getText());
		int hauteur = isDimensionOk(hauteurTf.getText());
		int ratio = isRatioOk(ratioTf.getText());
		
		if (hauteur !=-1 && largeur != -1 && ratio != -1) {
						//mettre au dimension
			Carte.getInstance(hauteur, largeur, ratio, chevalier_vector);
		}
		else {
			//message d'erreur
			System.out.println("Erreur de dimension");
			conditionOk = false;
		}
		
		

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
	 * Le nom doit etre rempli et pas plus de 30 caratères
	 */
	private boolean isPlayerNameOk(String[] joueurs) {
		
		//quelques vérifications de base
		for (String joueur : joueurs) {
			if (joueur.isEmpty() || joueur==null || joueur.length()>30) {
				return false;
			}
			
			//les noms doivent être uniques
			for (String joueur2 : joueurs) {
				if (joueur2.equals(joueur)) {
					return false;
				}
			}
		}
		
		// si tout est ok on retourne true
		return true;
	}
	
	/**
	 * retourne la dimension si elle est correcte, -1 sinon
	 * elle doit etre comprise entre 2 et 30 (a modifier si besoin)
	 */
	private int isDimensionOk(String dimTxt) {
		
		int dimension;
		
		try 
		{		
			 dimension = Integer.parseInt(dimTxt);	
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
