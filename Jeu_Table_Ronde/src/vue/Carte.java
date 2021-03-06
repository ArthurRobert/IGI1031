/**
 * Classe générant la fenêtre principale de notre interface graphique
 * Cette classe utilsera le design pattern singleton
 * 
 */
package vue;

import java.awt.HeadlessException;
import java.util.ArrayList;
import model.Chevalier;

public final class Carte {
	
	//instance singleton
	private static volatile Carte AuxQuatresCoinDuMonde=null;
	
	//Attributs
	private int nbCaseX;
	private int nbCaseY;
	private float ratio;
	private ArrayList<Chevalier> tabChevalier;
	private CartePanel cartePanel;


	



	//Constructeur
	private Carte(float ratio, int nbCaseX, int nbCaseY) throws HeadlessException {
		this.nbCaseX = nbCaseX;
		this.nbCaseY = nbCaseY;
		this.ratio = ratio;
		cartePanel = new  CartePanel(this.ratio, nbCaseX, nbCaseY);		
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
		//if (Carte.AuxQuatresCoinDuMonde==null){
			synchronized(Carte.class){
				if(Carte.AuxQuatresCoinDuMonde==null)
				{
					Carte.AuxQuatresCoinDuMonde= new Carte(ratio, largeur1, hauteur1);
					Carte.AuxQuatresCoinDuMonde.tabChevalier = c;
					Carte.AuxQuatresCoinDuMonde.ratio = ratio;
				}
			}
		//}
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


	public ArrayList<Chevalier> getTabChevalier() {
		return Carte.AuxQuatresCoinDuMonde.tabChevalier;
	}


	public void setTabChevalier(ArrayList<Chevalier> tabChevalier) {
		Carte.AuxQuatresCoinDuMonde.tabChevalier = tabChevalier;
	}
	
	public CartePanel getCartePanel() {
		return cartePanel;
	}


	public void setCartePanel(CartePanel cartePanel) {
		this.cartePanel = cartePanel;
	}
	
	public final static Carte newMap(int largeur1, int hauteur1, float ratio, ArrayList<Chevalier> c){
			synchronized(Carte.class){
				
				
	            	GameFrame gf = GameFrame.getInstance();
	            	gf.remove(gf.getMap().getCartePanel());
	            	gf.setMap(null);
	            	gf.repaint();
            	
			Carte.AuxQuatresCoinDuMonde= new Carte(ratio, largeur1, hauteur1);
			Carte.AuxQuatresCoinDuMonde.tabChevalier = c;
			Carte.AuxQuatresCoinDuMonde.ratio = ratio;
		}
		return Carte.AuxQuatresCoinDuMonde;
	}
	
	public void setNbCaseX(int nbCaseX) {
		this.nbCaseX = nbCaseX;
	}


	public void setNbCaseY(int nbCaseY) {
		this.nbCaseY = nbCaseY;
	}
}
