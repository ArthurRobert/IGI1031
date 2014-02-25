package controleur;

import model.*;

public class FactoryObjet {
	
	public static final ObjetObstacle[] DefObjet = {"ronce", "puit" ,"falaise", "roche"};
	
	public Object createObject(String typeObjet) { 
		if (typeObjet.equals(DefObjet)){
			Objet o = new ObjetObstacle(typeObjet);
		}
		
		else if (typeObjet.equals("graal")){
			
		}

		else if (typeObjet.equals("chateau")){
	
		}

		return null;
	}
}
