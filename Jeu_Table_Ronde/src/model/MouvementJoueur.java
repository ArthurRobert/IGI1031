package model;

import vue.Carte;


public class MouvementJoueur implements Mouvement {
	Chevalier chevalier;
	
	
	public MouvementJoueur(Chevalier chevalier){
		this.chevalier=chevalier;
	
	}
	
	
	
	@Override
	public boolean executeMouvement() {
		Carte carte = null;
		if (Carte.isCreated()){
			 carte = Carte.getInstance(0, 0, 0, null);
		}
		if (carte!=null){
			carte.getCartePanel().deplacementPossible(chevalier);
		}
		return false;
	}

}
