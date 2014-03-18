package model;

import java.util.ArrayList;

import vue.Carte;
import vue.Case;

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
		if(Carte.isCreated()){
			Case c;
			int x;
			int y;
			Carte carte = Carte.getInstance(0, 0, 0, null);
			for(int i=0; i< this.contenu.size();i++){
				
				x = (int)Math.random()*carte.getNbCaseX()-1;
				y = (int)Math.random()*carte.getNbCaseY()-1;
				
				while(carte.getCartePanel().getTabLignes().get(x).get(y).getElement().getType().toString() == "Chateau" 
							|| carte.getCartePanel().getTabLignes().get(x).get(y).getElement().getType().toString() =="ObjetGraal"){
						x = (int)Math.random()*carte.getNbCaseX()-1;
						y = (int)Math.random()*carte.getNbCaseY()-1;
				}
				
					carte.getCartePanel().getTabLignes().get(x).get(y).setElement(this.contenu.get(i));		
			}
			this.contenu.clear();
		}
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
