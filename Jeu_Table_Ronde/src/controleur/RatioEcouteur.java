package controleur;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

/**
 * Ecouteur pour le choix du ratio, 
 * 
 * reste à definir les critères de validité
 * 
 * */

public class RatioEcouteur implements ActionListener {

	private JTextField ratio;

	/**
	 * Constructeur de l'écouteur
	 * 
	 * @param ratio le ratio entré dans l'interface
	 */
	public RatioEcouteur(JTextField ratio) {
		super();
		this.ratio = ratio;
	}


	/**
	 * Vérification du ratio et action
	 */
	public void actionPerformed(ActionEvent e) {
		//Récupération du texte
		String ratioTxt = this.ratio.getText();
		
		//test du ratio
		int ratioInt = this.isRatioOk(ratioTxt);

		if (ratioInt == -1) 
		{
			Dialog dialog = new Dialog(new Frame(),"Ratio incorrect");
			dialog.setVisible(true);
		}
		
		//que faire avec le ratio ?
		//todo
	}

	/**
	 * vérifie que le ratio soit correct
	 */
	private int isRatioOk(String ratioTxt) {
		//critère pour le ratio à déterminer
		
		try 
		{		
			return Integer.parseInt(ratioTxt);			
		} 
		catch (NumberFormatException e) 
		{
			e.printStackTrace();
			return -1;
		}
	}

}
