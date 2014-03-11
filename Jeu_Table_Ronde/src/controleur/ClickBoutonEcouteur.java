package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class ClickBoutonEcouteur implements ActionListener{

	ArrayList<JButton> tabButton;


public ClickBoutonEcouteur(ArrayList<JButton> tabButton) {
		super();
		this.tabButton = tabButton;
	}

@Override
public void actionPerformed(ActionEvent e) {
    Object  source=e.getSource();
    
    //On cherche sur quel bouton l'utilisateur a cliqué
    for(int i=0;i<tabButton.size();i++){
    	if(source==tabButton.get(i)){
    		System.out.println(tabButton.get(i).getText()); //affichage du numéro de case dans la console
    	}//fin if
    }
	
}



}
