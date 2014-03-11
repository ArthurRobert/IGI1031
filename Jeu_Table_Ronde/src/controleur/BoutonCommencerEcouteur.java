package controleur;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
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
		 * Vérification du nom des joueurs
		 */	
		//obtention des noms des joueurs
		ArrayList<String> joueursNames = new ArrayList<String>();
		joueursNames.add(joueur1.getText());
		joueursNames.add(joueur2.getText());
		joueursNames.add(joueur3.getText());
		joueursNames.add(joueur4.getText());
		
		//récupération dimension et ratio
		int largeur = isDimensionOk(largeurTf.getText());
		int hauteur = isDimensionOk(hauteurTf.getText());
		int ratio = ratioTf.getValue();

		//test du nom des joueurs
		if (isPlayerNameOk(joueursNames))
		{
			/**
			 * vérification des dimensions
			 */
			if (hauteur !=-1 && largeur != -1 && ratio != -1) {
				/**
				 * Tests du type d'utilisateur
				 */
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
				
				//mettre au dimension, creation de la carte
				((NouvellePartie)o).setMapToFatherPanel(Carte.getInstance(hauteur, largeur, ratio, chevalier_vector));
				((NouvellePartie)o).dispose();
			}
			else {
				//message d'erreur
				System.out.println("Erreur de dimension");
			}
		}
		else 
		{
			//message d'erreur
			System.out.println("Erreur de nom de joueur");
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
			if (nomJoueur.isEmpty() || nomJoueur==null || nomJoueur.length()>30) {
				JOptionPane.showMessageDialog(new Frame(), "Vérifier les noms des joueurs");
				return false;
			}
			//les noms doivent être uniques
			copiListeJoueur.remove(nomJoueur);
			for (String autreJoueur: copiListeJoueur) {
				if (nomJoueur.equals(autreJoueur)){
					JOptionPane.showMessageDialog(new Frame(), "Nom de joueur en double : "+nomJoueur);
					return false;
				}
			}
		}
		// si tout est ok on retourne true
		return true;
	}
	
	/**
	 * retourne la dimension si elle est correcte, -1 sinon
	 * elle doit etre comprise entre 4 et 15 (a modifier si besoin)
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
			JOptionPane.showMessageDialog(new Frame(), "Erreur de dimension, format incorrect");
			return -1;
		}
		
		if (dimension<4 ||dimension > 15) {
			JOptionPane.showMessageDialog(new Frame(), "Erreur de dimension : les dimensions doivent être comprises entre 4 et 15");
			return -1;
		}
		else {
			return dimension;
		}
		
	}

}
