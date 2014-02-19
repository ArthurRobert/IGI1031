/**
 * Classe générant la fenêtre principale de notre interface graphique
 * Cette classe utilsera le design pattern singleton
 * 
 */
package vue;

import java.awt.HeadlessException;

public final class Carte {
	
	//instance singleton
	private static volatile Carte AuxQuatresCoinDuMonde=null;
	
	//Attributs
	private int largeur;
	private int hauteur;
	private CarteFrame carteFrame;
	
	//Constructeur
	private Carte(int largeur, int hauteur) throws HeadlessException {
		this.largeur = largeur;
		this.hauteur = hauteur;
		carteFrame = new  CarteFrame(largeur, hauteur);
		
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

}
