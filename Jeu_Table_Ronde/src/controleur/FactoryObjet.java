package controleur;

import model.*;

public class FactoryObjet {
	
	Objet o = null;
	
	public static final String[][] DefObjetObstacle = {{"ronce","-10"},{"puit","-15"},{"falaise","-20"}};
	public static final String[][] DefObjetGraal = {{"Excalibur","+50"},{"Pierre Fal Lial","+25"},{"Lance de lug","+30"},{"Chaudron Connaissance","+35"}};
	
	public Object createObject(String typeObjet) { 
		for (int i=0; i<DefObjetObstacle[1].length;i++){	
			if (typeObjet.equals(DefObjetObstacle[1][i])){
				o = new ObjetObstacle(DefObjetObstacle[0][i],Integer.parseInt(DefObjetObstacle[2][i]));
			}
		}
		
		else if (typeObjet.equals("graal")){
			for(int i=0;i<DefObjetGraal[1].length;i++){
				if (typeObjet.equals(DefObjetGraal[1][i]))
			o = new ObjetGraal(DefObjetGraal[0][i],Integer.parseInt(DefObjetGraal[3][i]));
		}

		else if (typeObjet.equals("chateau")){
	
		}
	}

		return null;
	}
}
