package model;

public class ObjetGraal extends Objet{
	
	String type = "";
	int poids;
	
	public ObjetGraal(String type, int poids, int nbVie) {
		super();
		this.type = type;
		this.poids = poids;
		this.nbVie = nbVie;
	}

}
