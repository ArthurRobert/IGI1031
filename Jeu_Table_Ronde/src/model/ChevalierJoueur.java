package model;

public class ChevalierJoueur extends Chevalier{

	public ChevalierJoueur(String unNom) {
		super(unNom);
		setMouvement(new MouvementJoueur());
		System.out.println("Vous avez créé un chevalier joueur");
		// TODO Auto-generated constructor stub
	}

}