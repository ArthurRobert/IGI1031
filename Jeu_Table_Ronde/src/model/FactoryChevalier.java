package model;

import java.util.ArrayList;

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
	
		return c;
	}	
	
	/**
	 * Fonction de suppression d'un chevalier
	 * Paramètre d'entrée : nom du joueur
	 * 
	 * */
	public void mourir(Chevalier c){
		// A FAIRE
	}
}