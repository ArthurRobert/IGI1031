package vue;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NouvellePartie extends JFrame {
	

	private static final long serialVersionUID = 1L;
	JButton startButton;
	public Object father;
	
	public NouvellePartie(Object o)  {
		super("Configurer une nouvelle partie");
		father = o;
		this.setSize(600, 350);
		this.setLayout(new BorderLayout());		

		JPanel panelSouth = new JPanel();
		panelSouth.setLayout(new BorderLayout());
		
		startButton = new JButton("Commencer");
		startButton.setPreferredSize(new Dimension(10,20));
		
		
		panelSouth.add(startButton,BorderLayout.CENTER);
		panelSouth.setBorder(BorderFactory.createEmptyBorder(0, 240, 10, 240));
		
		this.add(panelSouth,BorderLayout.SOUTH);
		
		JPanel panelCentre = new NouvellePartiePanelCentre(this);
		this.add(panelCentre,BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(NouvellePartie.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}

	public JButton getStartButton() {
		return startButton;
	}

	public void setStartButton(JButton startButton) {
		this.startButton = startButton;
	}
	
	public void setMapToFatherPanel(Carte c) {
		if (father instanceof GameFrame) 
		((GameFrame)father).setMap(c);
	}
	
}
