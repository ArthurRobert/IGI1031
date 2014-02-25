package model;

import java.util.ArrayList;

public class Sac {
	private int poids; 
	private ArrayList<ObjetGraal> contenu;

	Sac(){	
		poids = 0;
		contenu = new ArrayList<ObjetGraal>();
	}
		
	

	void ajoutObjetGraal(ObjetGraal graal){
		this.getContenu().add(graal);
		this.setPoids(this.getPoids() + graal.poids);
	}
	
	void viderSac(){
		this.contenu.removeAll(getContenu());
	}

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
