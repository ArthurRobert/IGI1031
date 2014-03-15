package model;

import java.awt.Color;

import vue.Carte;



public class MouvementOrdi implements Mouvement {
	Chevalier chevalier;


	public MouvementOrdi(Chevalier chevalier){
		this.chevalier=chevalier;

	}
	public boolean executeMouvement() {

		double mouvOrdiX = ((Math.random()*6)-3); //variable aléatoire de déplacement sur X comprise entre -3 et 3
		double mouvOrdiY = ((Math.random()*6)-3); //variable aléatoire de déplacement sur Y comprise entre -3 et 3

		Carte carte = null;
		if (Carte.isCreated()){
			 carte = Carte.getInstance(0, 0, 0, null);
		}
		if (carte!=null){
			carte.getCartePanel().getTabLignes().get(chevalier.getPositionX()).get(chevalier.getPositionY()).enleverPositionChevalier(chevalier.getNom());
		}
		
		//si mouvOrdiX compris entre -3 et -1, on ajoute -1
		if (mouvOrdiX < -1) {
			mouvOrdiX=-1;
			//chevalier.setPositionX(chevalier.getPositionX()-1);

			//si mouvOrdiX compris entre -1 et 1
		}else if (mouvOrdiX <1){
			mouvOrdiX=0;
			//ajoute 0 donc aucune action

			//si mouvement suivant X = 0 alors mouvement suivant Y != 0 (+1 ou -1 seulement)
			if (mouvOrdiX <0){
				mouvOrdiY=-1;
				//chevalier.setPositionY(chevalier.getPositionY()-1);
			}
			else {
				mouvOrdiY=1;
				//chevalier.setPositionY(chevalier.getPositionY()+1);
			}
		}

		//si mouvOrdiX compris entre 1 et 3, on ajoute 1	
		else {
			mouvOrdiX=1;
			//chevalier.setPositionX(chevalier.getPositionX()+1);	
		}

		if ((mouvOrdiX < -1) || (mouvOrdiX >= 1)){
			if (mouvOrdiY < -1){
				mouvOrdiY=-1;
				//chevalier.setPositionY(chevalier.getPositionY()-1);
			} else if (mouvOrdiY < 1){
				mouvOrdiY=0;
				//on ajoute 0
			} else {
				mouvOrdiY=1;
				//chevalier.setPositionY(chevalier.getPositionY()+1);
			}

		}
		
		//gestion des bords de carte sur x
		//depassement par la bas
		if( mouvOrdiX>0){
			if((chevalier.getPositionX()+mouvOrdiX)>carte.getNbCaseX()-1){
				chevalier.setPositionX(0);
			}
			else{
				chevalier.setPositionX(chevalier.getPositionX()+(int) mouvOrdiX);
			}
		}
		//dépassement par la haut
		else if (mouvOrdiX<0){
			if((chevalier.getPositionX()+mouvOrdiX)<0){
				chevalier.setPositionX(carte.getNbCaseX()-1);
			}
			else{
				chevalier.setPositionX(chevalier.getPositionX()+(int) mouvOrdiX);
			}
		}
		
		//gestion des bords de carte sur y
		//dépassement par le droite
		if( mouvOrdiY>0){
			if((chevalier.getPositionY()+mouvOrdiY)>carte.getNbCaseY()-1){
				chevalier.setPositionY(0);
			}
			else{
				chevalier.setPositionY(chevalier.getPositionY()+(int) mouvOrdiY);
			}
		}
		
		//dépassement par la gauche
		else if (mouvOrdiY<0){
			if((chevalier.getPositionY()+mouvOrdiY)<0){
				chevalier.setPositionY(carte.getNbCaseY()-1);
			}
			else{
				chevalier.setPositionY(chevalier.getPositionY()+(int) mouvOrdiY);
			}
		}
		
		System.out.println("Y:"+chevalier.getPositionY());
		System.out.println("X:"+chevalier.getPositionX());
		
		
		if (carte!=null){
			carte.getCartePanel().getTabLignes().get(chevalier.getPositionX()).get(chevalier.getPositionY()).marquerPositionChevalier(chevalier.getNom(),Color.BLUE);
		}

		return true;
	}

}
