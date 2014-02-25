package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NouvellePartie extends JFrame {

	public NouvellePartie()  {
		super("Configurer une nouvelle partie");
		this.setSize(600, 300);
		this.setLayout(new BorderLayout());		
		
		JPanel panelNorth = new JPanel();
		panelNorth.setLayout(new GridLayout(1,3));
		
		
		JLabel listeLabel = new JLabel("Listes des Joueurs");
		JLabel NbJoueur = new JLabel("Nombre de Joueurs Humain(s):");
		
		JComboBox listeDeroulante = new JComboBox();
		listeDeroulante.addItem("0");
		listeDeroulante.addItem("1");
		listeDeroulante.addItem("2");
		listeDeroulante.addItem("3");
		listeDeroulante.addItem("4");
		
		panelNorth.add(listeLabel);
		//panelNorth.add(NbJoueur);
		//panelNorth.add(listeDeroulante);
		
		this.add(panelNorth, BorderLayout.NORTH);
		
		JPanel panelCentre = new NouvellePartiePanelCentre(listeDeroulante);
		
		this.add(panelCentre,BorderLayout.CENTER);
		
		
		
		JPanel panelSouth = new JPanel();
		panelSouth.setLayout(new BorderLayout());
		
		JButton startButton = new JButton("Commencer");
		startButton.setPreferredSize(new Dimension(10,20));
		
		
		panelSouth.add(startButton,BorderLayout.CENTER);
		panelSouth.setBorder(BorderFactory.createEmptyBorder(0, 240, 10, 240));
		
		this.add(panelSouth,BorderLayout.SOUTH);
		
		
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
}
