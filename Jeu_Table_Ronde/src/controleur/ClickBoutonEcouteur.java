package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

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
	    ArrayList<ArrayList<Case>> tabLignes = cartePan.getTabLignes();
	    Chevalier chev=cartePan.getChev();
	    //On cherche sur quel bouton l'utilisateur a cliqué
	    for(int i=0;i<tabLignes.size();i++){
	    	for(int j=0;j<tabLignes.get(0).size();j++){
		    	if(source==tabLignes.get(i).get(j)){
		    		System.out.println(tabLignes.get(i).get(j).getText()); //affichage du numéro de case dans la console
		    		chev.setPositionX(i);
		    		chev.setPositionY(j);
		    	}//fin if
	    	}
	    }
		
	}
}
