package model;



public class MouvementOrdi implements Mouvement {
	Chevalier chevalier;


	public MouvementOrdi(Chevalier chevalier){
		this.chevalier=chevalier;

	}
	public boolean executeMouvement() {

		double mouvOrdiX = ((Math.random()*6)-3); //variable aléatoire de déplacement sur X comprise entre -3 et 3
		double mouvOrdiY = ((Math.random()*6)-3); //variable aléatoire de déplacement sur Y comprise entre -3 et 3

		//si mouvOrdiX compris entre -3 et -1, on ajoute -1
		if (mouvOrdiX < -1) {
			chevalier.setPositionX(chevalier.getPositionX()-1);

			//si mouvOrdiX compris entre -1 et 1
		}else if (mouvOrdiX <1){
			//ajoute 0 donc aucune action

			//si mouvement suivant X = 0 alors mouvement suivant Y != 0 (+1 ou -1 seulement)
			if (mouvOrdiX <0){	
				chevalier.setPositionY(chevalier.getPositionY()-1);
			}
			else {
				chevalier.setPositionY(chevalier.getPositionY()+1);
			}
		}

		//si mouvOrdiX compris entre 1 et 3, on ajoute 1	
		else { 
			chevalier.setPositionX(chevalier.getPositionX()+1);	
		}

		if ((mouvOrdiX < -1) || (mouvOrdiX >= 1)){
			if (mouvOrdiY < -1){
				chevalier.setPositionY(chevalier.getPositionY()-1);
			} else if (mouvOrdiY < 1){
				//on ajoute 0
			} else {
				chevalier.setPositionY(chevalier.getPositionY()+1);
			}

		}



		return true;
	}

}
