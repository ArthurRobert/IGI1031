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
	Integer positionClickX, positionClickY;

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
	    	if(source==tabLignes.get(i).get(j)){
	    		System.out.println(tabLignes.get(i).get(j).getText()); //affichage du numéro de case dans la console
	    		positionClickX=i;
	    		positionClickY=j;
	    		
	    	}//fin if
    	}
    }
	
}

public Integer getPositionClickX() {
	return positionClickX;
}

public void setPositionClickX(Integer positionClickX) {
	this.positionClickX = positionClickX;
}

public Integer getPositionClickY() {
	return positionClickY;
}

public void setPositionClickY(Integer positionClickY) {
	this.positionClickY = positionClickY;
}

public Integer[] getPositionClick(){
		Integer[] positionClick = {positionClickX,positionClickY};
		return positionClick;
	}
}
