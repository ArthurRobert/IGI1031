package controleur;

import vue.Carte;
import model.Chevalier;
import model.ChevalierJoueur;
import model.ChevalierOrdi;


public class FactoryChevalier {
	
	/**
	 * Fonction de création d'un chevalier
	 * Paramètres d'entrée : nom et type du joueur
	 * Elle renvoie un chevalier
	 * 
	 * */

	
	public static Chevalier addChevalier(String nom,String type){
		Chevalier c = null;
				
		if(type.equals("joueur")){
			c = new ChevalierJoueur(nom);
		
		}
		else if(type.equals("ordi")){
			c = new ChevalierOrdi(nom);
		}
		;
	
		return c;
	}
}