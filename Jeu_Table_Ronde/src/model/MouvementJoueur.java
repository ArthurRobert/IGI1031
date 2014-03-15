package model;

import javax.swing.plaf.SliderUI;

import vue.Carte;


public class MouvementJoueur implements Mouvement {
	Chevalier chevalier;
	
	
	public MouvementJoueur(Chevalier chevalier){
		this.chevalier=chevalier;
	
	}
	
	
	
	@Override
	public boolean executeMouvement() {
		int x,y;
		x = chevalier.getPositionX();
		y = chevalier.getPositionY();
		
		Carte carte = null;
		if (Carte.isCreated()){
			 carte = Carte.getInstance(0, 0, 0, null);
		}
		if (carte!=null){
			carte.getCartePanel().deplacementPossible(chevalier);
		}
		while(chevalier.getPositionX()==x && chevalier.getPositionY()==y);
			
		return true;
	}

}
