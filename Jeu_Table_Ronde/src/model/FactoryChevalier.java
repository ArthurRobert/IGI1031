package model;

import java.util.ArrayList;

public class FactoryChevalier {
	
	public static ArrayList<Chevalier> listeChevalier = new  ArrayList<Chevalier>();
	
	public ArrayList<Chevalier> getListeChevalier() {
		return listeChevalier;
	}
		
	
	/**
	 * Fonction d'ajout d'un chevalier à la liste de chevaliers
	 * Paramètres d'entrée : nom et type du joueur
	 * 
	 * */
	public static Chevalier addChevalier(String nom,String type){
		Chevalier c = null;

		System.out.println(listeChevalier.size());

			if (listeChevalier.size()<4){
				
						if(type.equals("joueur")){
							c = new ChevalierJoueur(nom);
						}
						else if(type.equals("ordi")){
							c = new ChevalierOrdi(nom);
						}
						listeChevalier.add(c);
					}		
		return c;
	}
	
	
	/**
	 * Fonction de suppression d'un chevalier
	 * Paramètre d'entrée : nom du joueur
	 * 
	 * */
	public void mourir(Chevalier c){
		listeChevalier.remove(c);
	}
}