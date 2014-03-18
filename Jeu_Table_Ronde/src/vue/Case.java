package vue;

import java.awt.Color;

import javax.swing.JButton;

import model.Objet;

public class Case extends JButton{

	private static final long serialVersionUID = 1L;
	int position;
	Objet element;
	String numeroCase;
	Color couleurFondDefaut;
	Boolean estOccupe = false;
	
	public Boolean getEstOccupe() {
		return estOccupe;
	}

	public void setEstOccupe(Boolean estOccupe) {
		this.estOccupe = estOccupe;
	}

	public Case() {
		super();
		this.couleurFondDefaut=this.getBackground();

	}

	public void setElement(Objet element) {
		this.element = element;
	}

	public Objet getElement() {
		return element;
	}
	
	public void removeElement(){
		this.element = null;
	}
	public void marquerPositionChevalier(String nomChevalier,Color couleurCase){
		this.numeroCase=this.getText();
		this.setText(nomChevalier);
		this.setBackground(couleurCase);
	}
	public void enleverPositionChevalier(String nomChevalier){
		this.setText(this.numeroCase);
		this.setBackground(couleurFondDefaut);
		
	}

	public String getNumeroCase() {
		return this.numeroCase;
	}

	public void setNumeroCase(String numeroCase) {
		this.numeroCase = numeroCase;
	}
	
	
}
