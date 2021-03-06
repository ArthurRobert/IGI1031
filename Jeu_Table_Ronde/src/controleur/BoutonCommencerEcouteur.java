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
import vue.CartePanel;
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

	private ArrayList<Chevalier> chevalier_vector = new ArrayList<Chevalier>(4);
	
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
		ArrayList<String> joueursNames = new ArrayList<String>(4);
		joueursNames.clear();
		joueursNames.add(joueur1.getText());
		joueursNames.add(joueur2.getText());
		joueursNames.add(joueur3.getText());
		joueursNames.add(joueur4.getText());
		
		//récupération dimension et ratio
		int largeur = isDimensionOk(largeurTf.getText());
		int hauteur = isDimensionOk(hauteurTf.getText());
		float ratio = (float) ((float) ratioTf.getValue()/100.0);
		Carte carte;
		chevalier_vector.clear();
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
					chevalier_vector.add(FactoryChevalier.addChevalier(hauteur,largeur,joueur1.getText(), "ordi"));
					System.out.println(joueur1.getText() + " dirigé par l'ordi !");
					
				}else {
					//notifier que le joueur 1 sera dirigé par un utilisateur
					chevalier_vector.add(FactoryChevalier.addChevalier(hauteur,largeur,joueur1.getText(), "joueur"));
					System.out.println(joueur1.getText() + " dirigé par un joueur !");
				}
				
				//Click on boutonOrdi2
				if (boutonOrdi2.isSelected()) {
					//notifier que le joueur 2 sera dirigé par l'ordi
					chevalier_vector.add(FactoryChevalier.addChevalier(hauteur,largeur,joueur2.getText(), "ordi"));
					System.out.println(joueur2.getText() + " dirigé par l'ordi !");
				}else {
					//notifier que le joueur 2 sera dirigé par un utilisateur
					chevalier_vector.add(FactoryChevalier.addChevalier(hauteur,largeur,joueur2.getText(), "joueur"));
					System.out.println(joueur2.getText() + " dirigé par un joueur !");
				}
				
				//Click on boutonOrdi3
				if (boutonOrdi3.isSelected()) {
					//notifier que le joueur 3 sera dirigé par l'ordi
					chevalier_vector.add(FactoryChevalier.addChevalier(hauteur,largeur,joueur3.getText(), "ordi"));
					System.out.println(joueur3.getText() + " dirigé par l'ordi !");
				}else {
					//notifier que le joueur 3 sera dirigé par un utilisateur
					chevalier_vector.add(FactoryChevalier.addChevalier(hauteur,largeur,joueur3.getText(), "joueur"));
					System.out.println(joueur3.getText() + " dirigé par un joueur !");
				}
				
				//Click on boutonOrdi4
				if (boutonOrdi4.isSelected()) {
					//notifier que le joueur 4 sera dirigé par l'ordi
					chevalier_vector.add(FactoryChevalier.addChevalier(hauteur,largeur,joueur4.getText(), "ordi"));
					System.out.println(joueur4.getText() + " dirigé par l'ordi !");
				}else {
					//notifier que le joueur 4 sera dirigé par un utilisateur
					chevalier_vector.add(FactoryChevalier.addChevalier(hauteur,largeur,joueur4.getText(), "joueur"));
					System.out.println(joueur4.getText() + " dirigé par un joueur !");
				}
				/*
				//test si la carte existe
				if(Carte.isCreated()){
					System.out.println("carte déjà créée");
					carte = Carte.getInstance(hauteur, largeur, ratio, chevalier_vector);
					carte.setRatio(ratio);
					carte.setTabChevalier(chevalier_vector);
					CartePanel cartePanel=new CartePanel(ratio, largeur, hauteur);
					carte.setCartePanel(cartePanel);
					carte.getCartePanel().repaint();
					
				}*/
				//si la carte n'existe pas, creation de la carte
				//mettre au dimension, creation de la carte
				if(!Carte.isCreated()){
					carte=Carte.getInstance(largeur, hauteur, ratio/2, chevalier_vector);
					((NouvellePartie)o).setMapToFatherPanel(carte);
				}
				else{
					carte=Carte.newMap(largeur, hauteur, ratio, chevalier_vector);
					((NouvellePartie)o).setMapToFatherPanel(carte);
				}
				
				//for(int i=0; i<carte.getTabChevalier().size();i++){
				//	positionDebutChevalier(chevalier_vector.get(i));
				//}
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
		// si tout est ok, on retourne true
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
	/**
	 * Methode permettant de générer aléatoirment la position des chevaliers
	 */
	/*public void positionDebutChevalier(Chevalier c){
		Carte.isCreated();
		Carte carte = Carte.getInstance(0, 0, 0, null);
		int nbCaseX=carte.getCartePanel().getTabLignes().size();
		int nbCaseY=carte.getCartePanel().getTabLignes().get(0).size();
		int randomX = (int)(Math.random()*nbCaseX);
		int randomY = (int)(Math.random()*nbCaseY);
		boolean caseVide=false;
		if(carte.getCartePanel().getTabLignes().get(randomX).get(randomY).getElement()==null){
			caseVide=true;
		}
		while(caseVide=false){
			randomX = (int)(Math.random()*nbCaseX);
			randomY = (int)(Math.random()*nbCaseX);
			if(carte.getCartePanel().getTabLignes().get(randomX).get(randomY).getElement()==null){
				caseVide=true;
			}
		}
		c.setPositionX(randomX);
		c.setPositionY(randomY);
		
		System.out.println("position du chevalier"+c.getNom()+": "+c.getPositionX()+c.getPositionY());
		
	}*/

}
