package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import vue.CartePanel;
import vue.Case;

public class ClickBoutonEcouteur implements ActionListener{

	ArrayList<ArrayList<Case>> tabLignes = null;
	CartePanel cartePan;


public ClickBoutonEcouteur(ArrayList<ArrayList<Case>> tabLignes, CartePanel cartePan) {
		super();
		this.tabLignes = tabLignes;
		this.cartePan = cartePan;
	}

@Override
public void actionPerformed(ActionEvent e) {
    Object  source=e.getSource();
    
    //On cherche sur quel bouton l'utilisateur a cliqué
    for(int i=0;i<tabLignes.size();i++){
    	for(int j=0;j<tabLignes.get(0).size();j++){
	    	if(source==tabLignes.get(i)){
	    		System.out.println(tabLignes.get(i).get(j).getText()); //affichage du numéro de case dans la console
	    		cartePan.deplacementPossible(i, j);
	    	
	    	
	    	}//fin if
    	}
    }
	
}



}
