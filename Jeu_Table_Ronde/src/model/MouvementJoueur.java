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
		int x=0,y=0;
		if (Carte.isCreated()){
			 carte = Carte.getInstance(0, 0, 0, null);
		}
		if (carte!=null){
			x= chevalier.getPositionX();
			y=chevalier.getPositionY();
			carte.getCartePanel().deplacementPossible(chevalier);
			
			while ((chevalier.getPositionX()==x) && (y==chevalier.getPositionY())){
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			};
			
		}
		return true;
	}

}
