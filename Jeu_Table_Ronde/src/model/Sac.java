package model;

import java.util.ArrayList;

public class Sac {
	private int poids; 
	private ArrayList<ObjetGraal> contenu;

	public Sac(){	
		poids = 0;
		contenu = new ArrayList<ObjetGraal>();
		System.out.println("sac cree");
	}
		
	
	/**
	 * Fonction d'ajout d'un objet Graal au sac 
	 * */
	public void ajoutObjetGraal(ObjetGraal graal){
		this.getContenu().add(graal);
		this.setPoids(this.getPoids() + graal.poids);
	}
	
	/**
	 * Fonction pour vider entièrement le sac
	 * */
	public void viderSac(){
		this.contenu.clear();
	}

	
	/**
	 * Fonctions Getter and Setter 
	 * */
	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public ArrayList<ObjetGraal> getContenu() {
		return contenu;
	}

	public void setContenu(ArrayList<ObjetGraal> contenu) {
		this.contenu = contenu;
	}
	
	
}
