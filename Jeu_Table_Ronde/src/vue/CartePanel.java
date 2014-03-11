package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import controleur.ClickBoutonEcouteur;

public class CartePanel extends JPanel  {

	ArrayList<JButton> tabButton = null;	
	int largeur;
	int hauteur;
	
	public  CartePanel(int largeur1, int hauteur1) {
		super();
		this.largeur=largeur1;
		this.hauteur=hauteur1;
		this.setLayout(new GridLayout(largeur,hauteur));
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.setBackground(Color.lightGray);
		
		String emplacement="case ";
		tabButton = new ArrayList<JButton>();
		for(int i=0;i<largeur;i++){
			for(int j=0;j<hauteur;j++){
				//System.out.println("for");
				emplacement=""+i+j;
				JButton boutonCase = new JButton();
				boutonCase.setText(emplacement);
				boutonCase.addActionListener(new ClickBoutonEcouteur(tabButton));
				this.add(boutonCase);
				tabButton.add(boutonCase);
			}
		}
		
	}//fin constructeur

	 
	 public int  getNbCaseX(){
		 return this.largeur;
	 }
	 
	 public void deplacementPossible(Integer x,Integer y){
		 System.out.println("effacement fini");
		 this.setLayout(new GridLayout(largeur,hauteur));
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.setBackground(Color.lightGray);
		

		 String emplacement;
			for(int i=0;i<largeur;i++){
				if(x<i-1 || x>i+1){
					for(int j=0;j<hauteur;j++){
						this.remove(tabButton.get(i+j));
						emplacement=""+i+j;
						JButton boutonCase = new JButton();
						boutonCase.setText(emplacement);
						boutonCase.addActionListener(new ClickBoutonEcouteur(tabButton));
						this.add(boutonCase);
						tabButton.add(boutonCase);
					}
				}
			}
			this.repaint();
			this.validate();
	 }
}
