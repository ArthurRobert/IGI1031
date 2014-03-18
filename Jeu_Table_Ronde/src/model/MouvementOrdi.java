package model;

import java.awt.Color;
import java.util.ArrayList;

import vue.Carte;



public class MouvementOrdi implements Mouvement {
	Chevalier chevalier;


	public MouvementOrdi(Chevalier chevalier){
		this.chevalier=chevalier;

	}
	public boolean executeMouvement() {


		int tabXY[ ] = new int[2];
		boolean positionOK=true;
		Carte carte = null;
		int compteur=0;
		if (Carte.isCreated()){
			 carte = Carte.getInstance(0, 0, 0, null);
		}
		if (carte!=null){
			carte.getCartePanel().getTabLignes().get(chevalier.getPositionX()).get(chevalier.getPositionY()).enleverPositionChevalier(chevalier.getNom());
			do{
				tabXY = mouvementRandom(carte);
				positionOK=true;
				// test si un chevalier est déjà à cette position
				for (Chevalier c: carte.getTabChevalier()){
				 if((c.getPositionX() == tabXY[0]) && (c.getPositionY() == tabXY[1])){
					 positionOK=false; 
				 }
				}
			compteur++;
			}while((positionOK==false) && (compteur<=8));
			
			if(positionOK){
				chevalier.setPositionX(tabXY[0]);
				chevalier.setPositionY(tabXY[1]);
				chevalier.setNivVie(chevalier.getNivVie() - chevalier.getSacChevalier().getPoids());
			}
			carte.getCartePanel().getTabLignes().get(chevalier.getPositionX()).get(chevalier.getPositionY()).marquerPositionChevalier(chevalier.getNom(),Color.BLUE);
		
		
		}
		

		return true;
	}
	
	private int[] mouvementRandom(Carte carte){
		
		double mouvOrdiX = ((Math.random()*6)-3); //variable aléatoire de déplacement sur X comprise entre -3 et 3
		double mouvOrdiY = ((Math.random()*6)-3); //variable aléatoire de déplacement sur Y comprise entre -3 et 3
		int tabXY[ ] = new int[2];
		int dX,dY=0;
		tabXY[0]=0;
		tabXY[1]=0;
		//si mouvOrdiX compris entre -3 et -1, on ajoute -1
				if (mouvOrdiX < -1) {
					dX=-1;
				}
				//si mouvOrdiX compris entre -1 et 1
				else if (mouvOrdiX < 1){
					dX=0;
					//si mouvement suivant X = 0 alors mouvement suivant Y != 0 (+1 ou -1 seulement)
					if (mouvOrdiX <0) dY=-1;
					else dY=1;
				}

				//si mouvOrdiX compris entre 1 et 3, on ajoute 1	
				else {
					dX=1;	
				}

				if ((mouvOrdiX < -1) || (mouvOrdiX >= 1)){
					if (mouvOrdiY < -1){
						dY=-1;
					} else if (mouvOrdiY < 1){
						dY=0;
						//on ajoute 0
					} else {
						dY=1;
					}

				}
				
				//gestion des bords de carte sur x
				//depassement par la bas
				if( dX>0){
					if((chevalier.getPositionX()+dX)>(carte.getNbCaseX()-1)){
						tabXY[0]=0;
					}
					else{
						tabXY[0]=chevalier.getPositionX() + dX;
					}
				}
				//dépassement par la haut
				else if (dX<0){
					if((chevalier.getPositionX()+dX)<0){
						tabXY[0]=(carte.getNbCaseX()-1);
					}
					else{
						tabXY[0]=chevalier.getPositionX()+ dX;
					}
				}
				else if(dX==0){
					tabXY[0]=chevalier.getPositionX();
				}
				
				//gestion des bords de carte sur y
				//dépassement par le droite
				if( dY>0){
					if((chevalier.getPositionY()+dY)>carte.getNbCaseY()-1){
						tabXY[1]=0;
					}
					else{
						tabXY[1]=chevalier.getPositionY()+ dY;
					}
				}
				
				//dépassement par la gauche
				else if (dY<0){
					if((chevalier.getPositionY()+dY)<0){
						tabXY[1]=(carte.getNbCaseY()-1);
					}
					else{
						tabXY[1]=chevalier.getPositionY()+ dY;
					}
				}
				else if(dY==0){
					tabXY[1]=chevalier.getPositionY();
				}
				
				return tabXY;
		
	}

}
