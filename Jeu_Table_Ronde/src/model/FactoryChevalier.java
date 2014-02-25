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
	
	
	
	public void addChevalier(Chevalier c){
		for (int i=0;i<listeChevalier.size();i++){
			if (!(c.getNom().equals(listeChevalier.get(i).getNom())) && listeChevalier.size()<4){
			listeChevalier.add(c);
			}
		}
		}
	public void mourir(Chevalier c){
		listeChevalier.remove(c);
	}
}

