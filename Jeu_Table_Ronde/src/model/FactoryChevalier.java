package model;

import java.util.ArrayList;

public class FactoryChevalier {
	
	public ArrayList<Chevalier> listeChevalier;
	
	public FactoryChevalier() {
		listeChevalier = new  ArrayList<Chevalier>();
	}


	public ArrayList<Chevalier> getListeChevalier() {
		return listeChevalier;
	}
	

	public void setListeChevalier(ArrayList<Chevalier> listeChevalier) {
		this.listeChevalier = listeChevalier;
	}
	
	
	
	public Chevalier addChevalier(String nom,String type){
		Chevalier c = null;
		for (int i=0;i<listeChevalier.size();i++){
			System.out.println("test1");

			if ((nom.equals(listeChevalier.get(i).getNom())) && listeChevalier.size()<4){
				System.out.println("test2");

				if(type.equals("joueur")){
					System.out.println("test3");
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

