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

public class CartePanel extends JPanel implements ActionListener {

	ArrayList<ArrayList<JButton>> tabLignes = null;	
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
		tabLignes = new ArrayList<ArrayList<JButton>>();
		for(int i=0;i<largeur;i++){
			ArrayList<JButton> ligneJButton= new ArrayList<JButton>();
			for(int j=0;j<hauteur;j++){
				//System.out.println("for");
				emplacement=""+i+j;
				Case boutonCase = new Case();
				boutonCase.setText(emplacement);
				boutonCase.addActionListener(this);
				boutonCase.setEnabled(false);
				this.add(boutonCase);
				ligneJButton.add(boutonCase);
			}
			tabLignes.add(ligneJButton);
		}
		
	}//fin constructeur

	 public  void    actionPerformed(ActionEvent e){
	        Object  source=e.getSource();
	        
	       //On cherche sur quel bouton l'utilisateur a cliqué
	        for(int i=0;i<tabLignes.size();i++){
	        	for(int j=0;j<(tabLignes.get(i)).size();j++){
		        	if(source==(tabLignes.get(i)).get(j)){
		        		System.out.println((tabLignes.get(i)).get(j).getText()); //affichage du numéro de case dans la console
		        	}//fin if
	        	}//fin for
	        }//fin for
	 
	 }//fin actionPerformed
	 
	 public int  getNbCaseX(){
		 return this.largeur;
	 }
	 
	 public void deplacementPossible(Integer x,Integer y){
		 
		 int nbColonne=tabLignes.size();
		 int nbLigne=(tabLignes.get(0)).size();
		 
		 //griser les deplacement impossible
		 for(int i=0;i<nbColonne;i++){
	        	for(int j=0;j<nbLigne;j++){
		        	tabLignes.get(i).get(j).setEnabled(false);
	        	}//fin for
	        }//fin for
		 /*
		 int numDerniereLigne=nbLigne-1;
		 int numDerniereColonne=nbColonne-1;

		 if(x==0){
			 if(y==0){
				 
			 }
			 else{
				 if(y==numDerniereColonne){
					 
				 }
				 else{
					 
				 }
			 }
		 }
		 */
		 
		 for(int i=x-1;i<=x+1;i++){
	        	for(int j=y-1;j<=y+1;j++){
	        		tabLignes.get(i).get(j).setEnabled(true);
	        		System.out.println("i: "+i+"j"+j);
	        	}//fin for
	        }//fin for
		 tabLignes.get(x).get(y).setEnabled(false);
		 
	 }
}
