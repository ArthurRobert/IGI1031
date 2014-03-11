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
	private float ratio;

	private CarteFrame carteFrame;


	private static ArrayList<Chevalier> tabChevalier;



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
	public final static Carte getInstance(int largeur1, int hauteur1, float ratio, ArrayList<Chevalier> c){
		if (Carte.AuxQuatresCoinDuMonde==null){
			synchronized(Carte.class){
				if(Carte.AuxQuatresCoinDuMonde==null)
				{
					Carte.AuxQuatresCoinDuMonde= new Carte(largeur1, hauteur1);
					Carte.AuxQuatresCoinDuMonde.tabChevalier = c;
					Carte.AuxQuatresCoinDuMonde.ratio = ratio;
				}
			}
		}
		return Carte.AuxQuatresCoinDuMonde;
	}
	
	public static boolean isCreated(){
		if (Carte.AuxQuatresCoinDuMonde ==null)
				return false;
		else return true;
	}
	
	public float getRatio() {
		return ratio;
	}


	public void setRatio(float ratio) {
		this.ratio = ratio;
	}


	public static ArrayList<Chevalier> getTabChevalier() {
		return tabChevalier;
	}


	public void setTabChevalier(ArrayList<Chevalier> tabChevalier) {
		this.tabChevalier = tabChevalier;
	}
	
	public CarteFrame getCarteFrame() {
		return carteFrame;
	}


	public void setCarteFrame(CarteFrame carteFrame) {
		this.carteFrame = carteFrame;
	}
}
