package model;



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
		Sac sacChevalier= new Sac();
	}



public void trouverObjet(ObjetGraal o){
	this.sacChevalier.ajoutObjetGraal(o);
	System.out.println("Objet ramassé");
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

}