package model;


public class Chevalier {
	private String type;
	private String nom;
	private Integer nivVie;
	private Integer positionX;
	private Integer positionY;
	
public Chevalier(String unNom){
	nom=unNom;
}



//public trouverObjet(){
	
//}



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

}