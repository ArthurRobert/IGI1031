package model;

public class ChevalierOrdi extends Chevalier{

	public ChevalierOrdi(String unNom){
		super(unNom);
		setMouvement(new MouvementOrdi());
		System.out.println("Vous avez créé un chevalier ordi");
		// TODO Auto-generated constructor stub
	}

}
