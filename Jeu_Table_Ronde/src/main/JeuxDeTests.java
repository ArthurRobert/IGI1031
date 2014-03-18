package main;


import java.io.File;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import model.ChevalierOrdi;
import model.Chevalier;
import model.Objet;
import model.ObjetGraal;
import vue.Carte;
import vue.CartePanel;
import vue.Case;
import vue.GameFrame;






import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.ChevalierOrdi;
import model.Chevalier;
import model.ObjetGraal;
import vue.Carte;
import vue.CartePanel;
import vue.Case;
import vue.GameFrame;
import vue.FinPartieVictoire;
import vue.FinPartieDefaite;

public class JeuxDeTests {

	public static void main(String[] args) {	
		
		GameFrame gm = GameFrame.getInstance();
		ArrayList<Chevalier> listeChev = new ArrayList<Chevalier>();
		Carte carte = null;
		boolean victoire = false;
		Objet testElement = null;
		Case c;
		String path = new File("").getAbsolutePath();
		String pathImageD=path+"/src/defaite.gif";
		String pathImageV=path+"/src/victoire.gif";
        Icon iconD = new ImageIcon(pathImageD);
        Icon iconV= new ImageIcon(pathImageV);
				
		// Test pour savoir si la carte a été créée par l'utilisateur (bouton Démarrer)
		do{
			if(Carte.isCreated()){
				carte = Carte.getInstance(0, 0, 0, null);
				
				// Récupération de la liste de chevaliers
				listeChev = carte.getTabChevalier();
				int i=0;
				ArrayList<ArrayList<Case>> caseActuelle= carte.getCartePanel().getTabLignes(); 
				
				// Gestion des tours de jeu
				while (i<listeChev.size()){
					
					// Appel de executeMouvement() pour déplacer le chevalier & test du booleen de déplacement
					if(listeChev.get(i).getMouvement().executeMouvement()){
						
						// Récupération de la case où se trouve le chevalier
						testElement = caseActuelle.get(listeChev.get(i).getPositionX()).get(listeChev.get(i).getPositionY()).getElement();
						c = caseActuelle.get(listeChev.get(i).getPositionX()).get(listeChev.get(i).getPositionY());
						
						// Chevalier sur une case avec objet
						if(testElement != null ){ 
							victoire = listeChev.get(i).trouverObjet(testElement, c);
							if(victoire){
								// Affichage victoire
								JOptionPane.showMessageDialog(null,
						                "Bravo, vous avez gagné!",
						                "Victoire", JOptionPane.INFORMATION_MESSAGE,
						                iconV);
								
								i=4;
							}
							else{
								if(listeChev.get(i).getNivVie()>0){
									JOptionPane.showMessageDialog(gm, "Joueur suivant");
								}
								else{
									// Affichage défaite
							        JOptionPane.showMessageDialog(null,
							                "Votre quête du graal s'achève ici...",
							                "Défaite", JOptionPane.INFORMATION_MESSAGE,
							                iconD);
									 listeChev.remove(i);
								}
							}
						}
						//Chevalier sur une case vide
						 else{ 
							 if(listeChev.get(i).getNivVie()>0){
									JOptionPane.showMessageDialog(gm, "Joueur suivant");
							 }
							 else{
								 FinPartieDefaite finDefaite = new FinPartieDefaite();
								 //gestion relacher objet a completer ligne en dessous
								// listeChev.get(i).getSacChevalier().getContenu()
								 
								 
								 
								 //////////////////////////////////////////////////
								 listeChev.remove(i);
							 }
						 }
						 i++;
		    		}
					else{
		    			JOptionPane.showMessageDialog(gm, "Veuillez vous déplacer");
					}
				}
			}
		}while (!victoire);
		
		
	}

}
