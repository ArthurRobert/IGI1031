package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

import vue.Carte;
import vue.NouvellePartie;
import model.Chevalier;

/**
 * Ecouteur pour le bouton demarrer de nouvelle partie
 * 
 * */
public class BoutonCommencerEcouteur implements ActionListener {

	private JTextField largeurTf, hauteurTf, joueur1, joueur2, joueur3, joueur4;
	
	private JSlider ratioTf;
	private JRadioButton boutonOrdi1, boutonOrdi2, boutonOrdi3, boutonOrdi4 ;
	
	private Object o;

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
	public BoutonCommencerEcouteur( JSlider ratioTf, JTextField largeurTf,
			JTextField hauteurTf, JTextField joueur1, JTextField joueur2,
			JTextField joueur3, JTextField joueur4, JRadioButton boutonOrdi1,
			JRadioButton boutonOrdi2, JRadioButton boutonOrdi3,
			JRadioButton boutonOrdi4,Object o) {
		
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
		this.o = o;
		
	}

	/**
	 * Actions a effectuer :
	 * 
	 * Verification des formats des champs, de leur valeur
	 */
	public void actionPerformed(ActionEvent arg0) 
	{
		
		
		/**
		 * Tests du type d'utilisateur
		 */
	
		
		/**
		 * Vérification du nom des joueurs
		 */	
		//obtention des noms des joueurs
		ArrayList<String> joueursNames = new ArrayList<String>();
		joueursNames.add(joueur1.getText());
		joueursNames.add(joueur2.getText());
		joueursNames.add(joueur3.getText());
		joueursNames.add(joueur4.getText());

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
		}
		
		
		/**
		 * vérification des dimensions
		 */
		//récupération
		int largeur = isDimensionOk(largeurTf.getText());
		int hauteur = isDimensionOk(hauteurTf.getText());
		int ratio = ratioTf.getValue();
		
		if (hauteur !=-1 && largeur != -1 && ratio != -1) {
						//mettre au dimension
			((NouvellePartie)o).setMapToFatherPanel(Carte.getInstance(hauteur, largeur, ratio, chevalier_vector));
		}
		else {
			//message d'erreur
			System.out.println("Erreur de dimension");
		}
	}
	
	/**
	 * retourne si le nom est correct ou non
	 * Le nom doit etre rempli et pas plus de 30 caratères
	 */
	private boolean isPlayerNameOk(ArrayList<String> joueurs) {
		

		ArrayList<String> copiListeJoueur = new ArrayList<String>(joueurs);
		
		//quelques vérifications de base
		for (String nomJoueur: joueurs) {
			if (joueurs.isEmpty() || joueurs==null || joueurs.size()>30) {
				return false;
			}
			copiListeJoueur.remove(nomJoueur);
			for (String autreJoueur: copiListeJoueur) {
				if (nomJoueur.equals(autreJoueur))
					return false;
			}
			//les noms doivent être uniques
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
