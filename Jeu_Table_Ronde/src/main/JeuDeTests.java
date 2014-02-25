package main;
import java.util.ArrayList;

import model.Chevalier;
import model.ChevalierJoueur;
import model.ChevalierOrdi;
import model.FactoryChevalier;
import vue.Carte;

public class JeuDeTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int largeur = 10;
		int hauteur = 10;
		Carte carte = Carte.getInstance(largeur, hauteur);
		
		FactoryChevalier tableRonde = new FactoryChevalier();
		
		Chevalier Perceval= tableRonde.addChevalier("Perceval","joueur");
		Chevalier Lancelot= tableRonde.addChevalier("Lancelot","ordi");
		
	   
		
		

		
	

}

	
}