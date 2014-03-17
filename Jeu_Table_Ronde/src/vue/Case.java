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
		numeroCase=this.getText();
		this.setText(nomChevalier);
		this.setBackground(couleurCase);
	}
	public void enleverPositionChevalier(String nomChevalier){
		this.setText(numeroCase);
		this.setBackground(couleurFondDefaut);
		
	}

	public String getNumeroCase() {
		return numeroCase;
	}

	public void setNumeroCase(String numeroCase) {
		this.numeroCase = numeroCase;
	}
	
	
}
