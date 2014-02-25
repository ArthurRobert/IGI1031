package model;

import java.util.ArrayList;
import vue.Carte;

public class FactoryChevalier {
	
	public static ArrayList<Chevalier> listeChevalier = new  ArrayList<Chevalier>();
	


	public ArrayList<Chevalier> getListeChevalier() {
		return listeChevalier;
	}
		
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
						System.out.println("joueur déjà pris");
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
	public void mourir(Chevalier c){
		listeChevalier.remove(c);
	}
}