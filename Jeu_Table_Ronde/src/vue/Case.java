package vue;

import javax.swing.JButton;

import model.Objet;

public class Case {

	int position;
	JButton bouton;
	Objet element;
	
	public Case(JButton bouton, Objet element) {
		super();
		this.bouton = bouton;
		this.element = element;
	}

	public JButton getBouton() {
		return bouton;
	}

	public void setBouton(JButton bouton) {
		this.bouton = bouton;
	}

	public Objet getElement() {
		return element;
	}
	
	
}
