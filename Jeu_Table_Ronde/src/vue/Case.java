package vue;

import java.awt.Color;

import javax.swing.JButton;

import model.Objet;

public class Case extends JButton{

	private static final long serialVersionUID = 1L;
	int position;
	Objet element;
	String numeroCase;
	
	public Case() {
		super();
	}

	public void setElement(Objet element) {
		this.element = element;
	}

	public Objet getElement() {
		return element;
	}
	public void marquerPositionChevalier(String nomChevalier,Color couleurCase){
		numeroCase=this.getText();
		this.setText(this.getText()+nomChevalier);
		this.setBackground(couleurCase);
	}
	public void enleverPositionChevalier(String nomChevalier){
		this.setText(numeroCase);
		Color couleurFondDefaut=new Color(238,238,238);
		this.setBackground(couleurFondDefaut);
		
	}
}
