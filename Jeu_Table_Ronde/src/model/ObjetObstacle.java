package model;

public class ObjetObstacle extends Objet{
	
	String type="";
	
	public ObjetObstacle(String type, int nbVie) {
		super();
		this.type = type;
		this.nbVie = nbVie;
	}
}
