package controleur;

import model.*;

public class FactoryObjet {
	
	Objet o = null;
	
	//DefObjetObstacle : {type, nbVie}
    public static final String[][] DefObjetObstacle = {{"ronce","-10"},{"puit","-15"},{"falaise","-20"}};
    
    //DefObjetGraal : {type, poids, nbVie}
	public static final String[][] DefObjetGraal = {{"Excalibur","10","50"},{"Pierre Fal Lial","15","25"},{"Lance de lug","20","30"},{"Chaudron Connaissance","25","35"}};

	
	//Creation des objets Obstacles
	public Object createObject(String typeObjet) { 	
		for (int i=0; i<DefObjetObstacle.length;i++){	
			if (typeObjet.equals(DefObjetObstacle[i][0])){
				o = new ObjetObstacle(DefObjetObstacle[i][0],Integer.parseInt(DefObjetObstacle[i][1]));
			}
		}
	
	//Creation des objets Graal
		for(int i=0;i<DefObjetGraal.length;i++){
				if (typeObjet.equals(DefObjetGraal[i][0])){
					o = new ObjetGraal(DefObjetGraal[i][0], Integer.parseInt(DefObjetGraal[i][1]),Integer.parseInt(DefObjetGraal[i][2]));
				}
		}
	//Creation du Chateau
		if (typeObjet.equals("chateau")){
			o = new Chateau(0);
	
		}
		return null;
	}
}
