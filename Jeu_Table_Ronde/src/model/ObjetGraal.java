package model;

public class ObjetGraal extends Objet{
	
	int poids;
	
	public ObjetGraal(String type, int poids, int nbVie) {
		super();
		this.setType(type);
		this.poids = poids;
		this.setNbVie(nbVie) ;
	}
}
