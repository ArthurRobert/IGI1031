package model;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vue.Case;
import vue.GameFrame;



public class Chevalier {
	
	//Attributs
	private String type;
	private String nom;
	private Integer nivVie;
	private Integer positionX;
	private Integer positionY;
	private Mouvement mouvement;
	private Sac sacChevalier;

	JFrame jf = null;
	
	//Constructeur
	public Chevalier(String unNom){
		nom=unNom;
		sacChevalier= new Sac();
		nivVie = 100;		
	}

public boolean trouverObjet(Objet o, Case c){
	String s ="";
	boolean victoire = false;
	this.setNivVie(nivVie+ o.getNbVie());
	if(o instanceof ObjetGraal){
		s = "";
		this.sacChevalier.ajoutObjetGraal((ObjetGraal) o);
		for(int i = 0; i<this.sacChevalier.getContenu().size();i++){
			
			s = s +"\n"+ this.sacChevalier.getContenu().get(i).getType().toString();
		}
		
		JOptionPane.showMessageDialog(jf, this.getNom() +" a ramassé " + o.getType() + "\nVotre niveau de vie est de "+ this.getNivVie() +"\nSac : "+s);
		c.removeElement();
	}
	if(o instanceof ObjetObstacle){
		JOptionPane.showMessageDialog(jf, this.getNom() +" a rencontré " + o.getType() + "\nVotre niveau de vie est de "+ this.getNivVie());

	}
	if(o instanceof Chateau && this.sacChevalier.getContenu().size() >= 4 && this.nivVie>0 ){
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

