package controleur;

import model.*;

public class FactoryObjet {
	
	Objet o = null;
	
	public static final String[][] DefObjetObstacle = {{"ronce","-10"},{"puit","-15"},{"falaise","-20"}};
	public static final String[][] DefObjetGraal = {{"ronce","-10"},{"puit","-15"},{"falaise","-20"}};
	
	public Object createObject(String typeObjet) { 
		for (int i; i<DefObjetObstacle.length;i++){	
			if (typeObjet.equals(DefObjetObstacle[i][0])){
				o = new ObjetObstacle(DefObjetObstacle[i][0],Integer.parseInt(DefObjetObstacle[i][1]));
			}
		}
		
		else if (typeObjet.equals("graal")){
			o = new ObjetGraal(DefObjet[0][i],Integer.parseInt(DefObjet[2][i]));
		}

		else if (typeObjet.equals("chateau")){
	
		}
	}

		return null;
	}
}
