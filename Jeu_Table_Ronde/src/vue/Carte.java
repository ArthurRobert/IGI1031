/**
 * Classe générant la fenêtre principale de notre interface graphique
 * Cette classe utilsera le design pattern singleton
 * 
 */
package vue;

import java.awt.HeadlessException;
import java.util.ArrayList;

import model.Chevalier;
import model.FactoryChevalier;

public final class Carte {
	
	//instance singleton
	private static volatile Carte AuxQuatresCoinDuMonde=null;
	
	//Attributs
	private int nbCaseX;
	private int nbCaseY;
	private CarteFrame carteFrame;
	private ArrayList<Chevalier> tabChevalier;
	
	//Constructeur
	private Carte(int nbCaseX, int nbCaseY) throws HeadlessException {
		this.nbCaseX = nbCaseX;
		this.nbCaseY = nbCaseY;
		carteFrame = new  CarteFrame(nbCaseX, nbCaseY);
		
	}
	
	
	//getters & setters
	public int getNbCaseX() {
		return nbCaseX;
	}

	public int getNbCaseY() {
		return nbCaseY;
	}
	
	
	/**
	 * Methode permettant de renvoyer une instance de la classe
	 * 
	 */
	public final static Carte getInstance(int largeur1, int hauteur1){
		if (Carte.AuxQuatresCoinDuMonde==null){
			synchronized(Carte.class){
				if(Carte.AuxQuatresCoinDuMonde==null)
				{
					Carte.AuxQuatresCoinDuMonde= new Carte(largeur1, hauteur1);
				}
			}
		}
		return Carte.AuxQuatresCoinDuMonde;
	}
	
	//Creation de Chevalier
	public void orderChevalier(String nom, String type){
		Chevalier c=FactoryChevalier.addChevalier(nom, type);
	}
}
