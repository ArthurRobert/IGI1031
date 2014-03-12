package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controleur.ClickBoutonEcouteur;
import controleur.FactoryObjet;

public class CartePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	ArrayList<ArrayList<Case>> tabLignes = null;	
	int largeur;
	int hauteur;
	
	
	public  CartePanel(float ratio, int largeur1, int hauteur1) {
		super();
		FactoryObjet factoryObjet = new FactoryObjet(ratio, largeur1*hauteur1);
		this.largeur=largeur1;
		this.hauteur=hauteur1;
		this.setLayout(new GridLayout(largeur,hauteur));
		this.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		this.setBackground(Color.lightGray);
		
		String emplacement="case ";
		tabLignes = new ArrayList<ArrayList<Case>>();
		for(int i=0;i<largeur;i++){
			ArrayList<Case> ligneJButton= new ArrayList<Case>();
			for(int j=0;j<hauteur;j++){
				//System.out.println("for");
				emplacement=""+i+j;
				Case boutonCase = new Case();
				boutonCase.setElement(factoryObjet.createObject());
				boutonCase.setText(emplacement);
				//boutonCase.addActionListener(this);
				boutonCase.addActionListener(new ClickBoutonEcouteur(tabLignes,this));
				boutonCase.setEnabled(false);
				this.add(boutonCase);
				ligneJButton.add(boutonCase);
			}
			tabLignes.add(ligneJButton);
		}
		
	}//fin constructeur

	/* public  void    actionPerformed(ActionEvent e){
	        Object  source=e.getSource();
	        
	       //On cherche sur quel bouton l'utilisateur a cliqué
	        for(int i=0;i<tabLignes.size();i++){
	        	for(int j=0;j<(tabLignes.get(i)).size();j++){
		        	if(source==(tabLignes.get(i)).get(j)){
		        		System.out.println((tabLignes.get(i)).get(j).getText()); //affichage du numéro de case dans la console
		        		this.deplacementPossible(i, j);
		        	}//fin if
	        	}//fin for
	        }//fin for
	 
	 }//fin actionPerformed*/
	 
	 public int  getNbCaseX(){
		 return this.largeur;
	 }
	 
	 public void deplacementPossible(Integer x,Integer y){
		 
		 
		 int nbLigne=tabLignes.size();
		 int nbColonne=tabLignes.get(0).size();
		 //griser les deplacement impossible
		 for(int i=0;i<nbLigne;i++){
	        	for(int j=0;j<nbColonne;j++){
		        	tabLignes.get(i).get(j).setEnabled(false);
	        	}//fin for
	        }//fin for
		 
		 int numDerniereLigne=nbLigne-1;
		 int numDerniereColonne=nbColonne-1;

		 if(x==0){
			 
			 //Corner  top left
			 if(y==0){
				 tabLignes.get(numDerniereLigne).get(numDerniereColonne).setEnabled(true);
				 tabLignes.get(numDerniereLigne).get(0).setEnabled(true);
				 tabLignes.get(numDerniereLigne).get(1).setEnabled(true);
				 
				 tabLignes.get(0).get(numDerniereColonne).setEnabled(true);
				 tabLignes.get(0).get(1).setEnabled(true);
				 
				 tabLignes.get(1).get(numDerniereColonne).setEnabled(true);
				 tabLignes.get(1).get(0).setEnabled(true);
				 tabLignes.get(1).get(1).setEnabled(true);
			 }
			 else{
				 
				 //Corner top right
				 if(y==numDerniereColonne){
					 tabLignes.get(numDerniereLigne).get(numDerniereColonne-1).setEnabled(true);
					 tabLignes.get(numDerniereLigne).get(numDerniereColonne).setEnabled(true);
					 tabLignes.get(numDerniereLigne).get(0).setEnabled(true);
					 
					 tabLignes.get(0).get(numDerniereColonne-1).setEnabled(true);
					 tabLignes.get(0).get(0).setEnabled(true);
					 
					 tabLignes.get(1).get(numDerniereColonne-1).setEnabled(true);
					 tabLignes.get(1).get(numDerniereColonne).setEnabled(true);
					 tabLignes.get(1).get(0).setEnabled(true);
					 
				 }
				 else{
					 // top ligne
					 for(int i=x;i<=x+1;i++){
				        	for(int j=y-1;j<=y+1;j++){
				        		tabLignes.get(i).get(j).setEnabled(true);
				        	}//fin for
				        }//fin for
					 for(int j=y-1;j<=y+1;j++){
			        		tabLignes.get(numDerniereLigne).get(j).setEnabled(true);
			        	}//fin for
				 }
			 }
		 }
		 else{
			 if(x==numDerniereLigne){
				 if(y==0){
					 //corner bottom left
					 tabLignes.get(numDerniereLigne-1).get(numDerniereColonne).setEnabled(true);
					 tabLignes.get(numDerniereLigne-1).get(0).setEnabled(true);
					 tabLignes.get(numDerniereLigne-1).get(1).setEnabled(true);
					 
					 tabLignes.get(numDerniereLigne).get(numDerniereColonne).setEnabled(true);
					 tabLignes.get(numDerniereLigne).get(1).setEnabled(true);
					 
					 tabLignes.get(0).get(numDerniereColonne).setEnabled(true);
					 tabLignes.get(0).get(0).setEnabled(true);
					 tabLignes.get(0).get(1).setEnabled(true);
				 }
				 else{
					 if(y==numDerniereColonne){
						//corner bottom right
						 tabLignes.get(numDerniereLigne-1).get(numDerniereColonne-1).setEnabled(true);
						 tabLignes.get(numDerniereLigne-1).get(numDerniereColonne).setEnabled(true);
						 tabLignes.get(numDerniereLigne-1).get(0).setEnabled(true);
						 
						 tabLignes.get(numDerniereLigne).get(numDerniereColonne-1).setEnabled(true);
						 tabLignes.get(numDerniereLigne).get(0).setEnabled(true);
						 
						 tabLignes.get(0).get(numDerniereColonne-1).setEnabled(true);
						 tabLignes.get(0).get(numDerniereColonne).setEnabled(true);
						 tabLignes.get(0).get(0).setEnabled(true);
					 }
					 else{
						// top ligne
						 for(int i=x-1;i<x+1;i++){
					        	for(int j=y-1;j<=y+1;j++){
					        		tabLignes.get(i).get(j).setEnabled(true);
					        	}//fin for
					        }//fin for
						 for(int j=y-1;j<=y+1;j++){
				        		tabLignes.get(0).get(j).setEnabled(true);
				        	}//fin for						 
					 }
				 }
				 
			 }
			 else{
				 if(y==0){
					 for(int i=x-1;i<=x+1;i++){
				        	for(int j=y;j<=y+1;j++){
				        		tabLignes.get(i).get(j).setEnabled(true);
				        	}//fin for
				        }//fin for
					 for(int i=x-1;i<=x+1;i++){
						 tabLignes.get(i).get(numDerniereColonne).setEnabled(true);
					 }
				 }
				 else{
					 if(y==numDerniereColonne){
						 for(int i=x-1;i<=x+1;i++){
					        	for(int j=y-1;j<y+1;j++){
					        		tabLignes.get(i).get(j).setEnabled(true);
					        	}//fin for
					        }//fin for
						 for(int i=x-1;i<=x+1;i++){
							 tabLignes.get(i).get(0).setEnabled(true);
						 }						 
					 }
					 else{
						 //All other cases
						 for(int i=x-1;i<=x+1;i++){
					        	for(int j=y-1;j<=y+1;j++){
					        		tabLignes.get(i).get(j).setEnabled(true);
					        	}//fin for
					        }//fin for 
					 }
				 }
			 }
		 }
		 tabLignes.get(x).get(y).setEnabled(false);
		 
	 }
}
