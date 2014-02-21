package vue;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

public class CartePanel extends JPanel implements ActionListener {

	ArrayList<JButton> tabButton = null;	
	public  CartePanel(int largeur, int hauteur) {
		super();
		this.setLayout(new GridLayout(largeur,hauteur));	
		String emplacement="case ";
		tabButton = new ArrayList<JButton>();
		for(int i=0;i<largeur;i++){
			for(int j=0;j<hauteur;j++){
				//System.out.println("for");
				emplacement=emplacement+i+j;
				JButton boutonCase = new JButton();
				boutonCase.setText(emplacement);
				boutonCase.addActionListener(this);
				emplacement="case "; //remise à zéro du nom
				this.add(boutonCase);
				tabButton.add(boutonCase);
			}
		}
		
		
	}//fin constructeur

	 public  void    actionPerformed(ActionEvent e){
	        Object  source=e.getSource();
	        
	        //On cherche sur quel bouton l'utilisateur a cliqué
	        for(int i=0;i<tabButton.size();i++){
	        	if(source==tabButton.get(i)){
	        		System.out.println(tabButton.get(i).getText()); //affichage du numéro de case dans la console
	        	}//fin if
	        }//fin for
	 
	 }//fin actionPerformed
}
