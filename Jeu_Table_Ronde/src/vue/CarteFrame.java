package vue;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class CarteFrame extends JFrame{
	
	public CarteFrame(int largeur, int hauteur){
		super("Aux quatre coins du monde");
		
		//taille de la fenêtre
		this.setSize(largeur,hauteur);
		//croix rouge active
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//rendre la fenêtre visible
		this.setVisible(true);
		
		this.add(new CartePanel(largeur,hauteur));
		
	}

}
