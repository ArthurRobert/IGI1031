package vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Hashtable;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextField;

import controleur.BoutonCommencerEcouteur;

public class NouvellePartiePanelCentre extends JPanel {
	
	private static final long serialVersionUID = 1L;
	NouvellePartie nouvellePartie;
	BoutonCommencerEcouteur bp = null;
    static final int FPS_MIN = 0;
    static final int FPS_MAX = 100;
    static final int FPS_INIT = 0; 

	NouvellePartiePanelCentre(NouvellePartie nouvellePartie) {
		super();
		this.nouvellePartie=nouvellePartie;
		this.setLayout(new BorderLayout());
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		JPanel panelNord = new JPanel();
		JPanel panelSud = new JPanel();
		panelNord.setLayout(new GridLayout(5,3));
		panelSud.setLayout(new GridLayout(3,2));
		
		
		
		//Panel nord
		JLabel pc = new JLabel("PC");
		JLabel humain = new JLabel("Humain");
		JLabel nomJoueur = new JLabel("Nom joueur");
		
		//ajout element panel nord	
		panelNord.add(humain);
		panelNord.add(pc);
		panelNord.add(nomJoueur);
		
		JRadioButton buttonHumain1 = new JRadioButton();
		JRadioButton buttonOrdi1 = new JRadioButton();
		buttonOrdi1.setSelected(true);
		ButtonGroup typeJoueur1 = new ButtonGroup();
		typeJoueur1.add(buttonHumain1);
		typeJoueur1.add(buttonOrdi1);
		panelNord.add(buttonHumain1);
		panelNord.add(buttonOrdi1);
		JTextField joueur1 = new JTextField("Arthur");
		panelNord.add(joueur1);
		
		JRadioButton buttonHumain2 = new JRadioButton();
		JRadioButton buttonOrdi2 = new JRadioButton();
		buttonOrdi2.setSelected(true);
		ButtonGroup typeJoueur2 = new ButtonGroup();
		typeJoueur2.add(buttonHumain2);
		typeJoueur2.add(buttonOrdi2);
		panelNord.add(buttonHumain2);
		panelNord.add(buttonOrdi2);
		JTextField joueur2 = new JTextField("Perceval");
		panelNord.add(joueur2);
		
		JRadioButton buttonHumain3 = new JRadioButton();
		JRadioButton buttonOrdi3 = new JRadioButton();
		buttonOrdi3.setSelected(true);
		ButtonGroup typeJoueur3 = new ButtonGroup();
		typeJoueur3.add(buttonHumain3);
		typeJoueur3.add(buttonOrdi3);
		panelNord.add(buttonHumain3);
		panelNord.add(buttonOrdi3);
		JTextField joueur3 = new JTextField("Lancelot");
		panelNord.add(joueur3);
		
		JRadioButton buttonHumain4 = new JRadioButton();
		JRadioButton buttonOrdi4= new JRadioButton();
		buttonOrdi4.setSelected(true);
		ButtonGroup typeJoueur4 = new ButtonGroup();
		typeJoueur4.add(buttonHumain4);
		typeJoueur4.add(buttonOrdi4);
		panelNord.add(buttonHumain4);
		panelNord.add(buttonOrdi4);
		JTextField joueur4 = new JTextField("Karadoc");
		panelNord.add(joueur4);
		
		
		//Panel sud
		JLabel ratioLabel = new JLabel("Ratio");
	
		   //Create the slider
          JSlider ratio = new JSlider(JSlider.HORIZONTAL,FPS_MIN, FPS_MAX, FPS_INIT);
          ratio.setMajorTickSpacing(1);
          ratio.setPaintTicks(true);

          //Create the label table
          Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
          labelTable.put( new Integer( 0 ), new JLabel("Facile") );
          labelTable.put( new Integer( FPS_MAX ), new JLabel("Difficile") );
          ratio.setLabelTable( labelTable );

          ratio.setPaintLabels(true);
		
		JLabel hauteurCarte = new JLabel("Hauteur de la carte");
		JTextField tfHauteurCarte = new JTextField();
		
		JLabel largeurCarte = new JLabel("Largeur de la carte");
		JTextField tfLargeurCarte = new JTextField();
		
		//ajout element dans panel sud
		panelSud.add(ratioLabel);
		panelSud.add(ratio);
		panelSud.add(hauteurCarte);
		panelSud.add(tfHauteurCarte);
		panelSud.add(largeurCarte);
		panelSud.add(tfLargeurCarte);
		
		this.add(panelNord,BorderLayout.NORTH);
		this.add(panelSud,BorderLayout.SOUTH);
		
		//StartButton pour Nicolas B
		
		JButton startButton = nouvellePartie.getStartButton();

		startButton.addActionListener(new BoutonCommencerEcouteur( ratio ,tfLargeurCarte , tfHauteurCarte , joueur1, joueur2, joueur3, joueur4, buttonOrdi1, buttonOrdi2 , buttonOrdi3, buttonOrdi4, this.nouvellePartie));
				
		
	}
	
}
