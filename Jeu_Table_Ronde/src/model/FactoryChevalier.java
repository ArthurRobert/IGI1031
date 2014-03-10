package model;

import java.util.ArrayList;

public class FactoryChevalier {
	
	public static ArrayList<Chevalier> listeChevalier = new  ArrayList<Chevalier>();
	


	public ArrayList<Chevalier> getListeChevalier() {
		return listeChevalier;
	}
		
	
	/**
	 * Fonction d'ajout d'un chevalier à la liste de chevaliers
	 * avec test si le nom est déjà utilisé
	 * Paramètres d'entrée : nom et type du joueur
	 * 
	 * */
	public static Chevalier addChevalier(String nom,String type){
		Chevalier c = null;
		Boolean pris= false;
		System.out.println(listeChevalier.size());

			if (listeChevalier.size()!= 0){
				for (int i=0;i<listeChevalier.size();i++){				
					if (!(nom.equals(listeChevalier.get(i).getNom()))){
					}
					else{
						pris = true;
						System.out.println("nom de joueur déjà pris");
					}
				}
			if (listeChevalier.size()<4 && pris.equals(false)){
				
						if(type.equals("joueur")){
							c = new ChevalierJoueur(nom);
						}
						else if(type.equals("ordi")){
							c = new ChevalierOrdi(nom);
						}
						listeChevalier.add(c);
					}
			}
			else{
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