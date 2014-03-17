package controleur;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.Chevalier;
import vue.CartePanel;
import vue.Case;

public class ClickBoutonEcouteur implements ActionListener{

	CartePanel cartePan;

public ClickBoutonEcouteur(CartePanel cartePan) {
		super();
		this.cartePan = cartePan;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    Object  source=e.getSource();
	    while(((Case) source).getEstOccupe()){
	    	System.out.println("case occupée, svp cliquez autre part");
	    	this.actionPerformed(e);
	    }
	    ArrayList<ArrayList<Case>> tabLignes = cartePan.getTabLignes();
	    Chevalier chev=cartePan.getChev();
	    //On cherche sur quel bouton l'utilisateur a cliqué
	    for(int i=0;i<tabLignes.size();i++){
	    	for(int j=0;j<tabLignes.get(0).size();j++){
		    	if(source==tabLignes.get(i).get(j)){
		    		//System.out.println(tabLignes.get(i).get(j).getText()); //affichage du numéro de case dans la console		    		
		    		tabLignes.get(chev.getPositionX()).get(chev.getPositionY()).enleverPositionChevalier(chev.getNom());	
		    		tabLignes.get(chev.getPositionX()).get(chev.getPositionY()).setEstOccupe(false);
		    		chev.setPositionX(i);
		    		chev.setPositionY(j);
		    		tabLignes.get(i).get(j).marquerPositionChevalier(chev.getNom(), Color.blue);
		    		cartePan.deplacementPossible(chev);
		    	}//fin if
	    	}
	    }
		((Case) source).setEstOccupe(true);
	}
}
