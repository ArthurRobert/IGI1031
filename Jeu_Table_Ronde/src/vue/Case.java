package vue;

import java.awt.Color;

import javax.swing.JButton;

import model.Objet;

public class Case extends JButton{

	private static final long serialVersionUID = 1L;
	int position;
	Objet element;
	
	public Case() {
		super();
	}

	public void setElement(Objet element) {
		this.element = element;
	}

	public Objet getElement() {
		return element;
	}
	@SuppressWarnings("deprecation")
	public void marquerPositionChevalier(String nomChevalier,Color couleurCase){
		this.setLabel(this.getLabel()+nomChevalier);
		this.setBackground(couleurCase);
	}
	
}
