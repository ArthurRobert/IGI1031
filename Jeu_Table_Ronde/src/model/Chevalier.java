package model;

import org.hamcrest.core.IsInstanceOf;



public class Chevalier {
	
	//Attributs
	private String type;
	private String nom;
	private Integer nivVie;
	private Integer positionX;
	private Integer positionY;
	private Mouvement mouvement;
	private Sac sacChevalier;
	
	//Constructeur
	public Chevalier(String unNom){
		nom=unNom;
		sacChevalier= new Sac();
		nivVie = 100;
	}



public boolean trouverObjet(Objet o){
	boolean victoire = false;
	if(o instanceof ObjetGraal){
		this.sacChevalier.ajoutObjetGraal((ObjetGraal) o);
		this.setNivVie(nivVie+ o.getNbVie());
		System.out.println("Objet ramassé");
	}
	if(o instanceof ObjetObstacle){
		this.setNivVie(nivVie+ o.getNbVie());
		System.out.println("obstacle rencontré");

	}
	if(o instanceof Chateau && this.sacChevalier.getContenu().size() == 4 && this.nivVie>0 ){
		victoire = true;
	}
	return victoire;
}


	
	/**
	 * Getter and Setter
	 * 
	 * */
	public Sac getSacChevalier() {
			return sacChevalier;
		}
	
	public void setSacChevalier(Sac sacChevalier) {
		this.sacChevalier = sacChevalier;
	}
	
	public Integer getNivVie() {
		return nivVie;
	}
	
	public void setNivVie(Integer nivVie) {
		this.nivVie = nivVie;
	}
	
	public Integer getPositionX() {
		return positionX;
	}
	
	public void setPositionX(Integer positionX) {
		this.positionX = positionX;
	}
	
	public Integer getPositionY() {
		return positionY;
	}
	
	public void setPositionY(Integer positionY) {
		this.positionY = positionY;
	}
	
	public String getNom(){
		return nom;
	}
	
	public void setNom(String unNom) {
		nom = unNom;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Mouvement getMouvement() {
		return mouvement;
	}
	
	public void setMouvement(Mouvement mouvement) {
		this.mouvement = mouvement;
	}
	
	public Integer[] getPosition(){
		
		Integer[] position = {positionX,positionY};
		return position;
		
		}
	}

