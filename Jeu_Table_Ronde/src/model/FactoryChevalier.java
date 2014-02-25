package model;

import java.util.ArrayList;

public class FactoryChevalier {
	
	ArrayList<Chevalier> listeChevalier = new  ArrayList<Chevalier>();
	
	public ArrayList<Chevalier> getListeChevalier() {
		return listeChevalier;
	}
	

	public void setListeChevalier(ArrayList<Chevalier> listeChevalier) {
		this.listeChevalier = listeChevalier;
	}
	
	
	
	public Chevalier addChevalier(String nom,String type){
		Chevalier c = null;
		for (int i=0;i<listeChevalier.size();i++){
			if (!(nom.equals(listeChevalier.get(i).getNom())) && listeChevalier.size()<4){
				if(type.equals("joueur")){
					c = new ChevalierJoueur(nom);
				}
				else if(type.equals("ordi")){
					c = new ChevalierOrdi(nom);
				}
			listeChevalier.add(c);
			}
		}
		return c;
		
		}
	public void mourir(Chevalier c){
		listeChevalier.remove(c);
	}
}

