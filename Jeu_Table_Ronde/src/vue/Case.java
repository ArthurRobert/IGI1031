package vue;

import javax.swing.JButton;

import model.Objet;

public class Case extends JButton{

	int position;
	Objet element;
	
	public Case(JButton bouton, Objet element) {
		super();
		this.element = element;
	}

	public Objet getElement() {
		return element;
	}
	
}
