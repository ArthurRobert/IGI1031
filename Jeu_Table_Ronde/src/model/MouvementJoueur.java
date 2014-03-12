package model;

import vue.Carte;
import controleur.ClickBoutonEcouteur;

public class MouvementJoueur implements Mouvement {
	Chevalier chevalier;
	
	
	public MouvementJoueur(Chevalier chevalier, ClickBoutonEcouteur click){
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
