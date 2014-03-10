package model;

public class ChevalierOrdi extends Chevalier{

	//Constructeur
	public ChevalierOrdi(String unNom){
		super(unNom);
		setMouvement(new MouvementOrdi());
		System.out.println("Vous avez créé un chevalier ordi");
		
	}

}
