package controleur;

import java.util.ArrayList;
import model.*;

public class FactoryObjet {


	Objet o = null;
	int nbCreated = 0; 
	double ratio;
	Integer sizeMap;
	private ArrayList<ObjetObstacle> listeObstacle = new ArrayList<ObjetObstacle>();
	private ArrayList<ObjetGraal> listeGraal = new ArrayList<ObjetGraal>();


	public FactoryObjet(double ratio,Integer sizeMap) {
		super();
		this.ratio = ratio;
		this.sizeMap=sizeMap;



	}


	//DefObjetObstacle : {type, nbVie}
	public static final String[][] DefObjetObstacle = {{"ronce","-10"},{"puit","-15"},{"falaise","-20"}};

	//DefObjetGraal : {type, poids, nbVie}
	public static final String[][] DefObjetGraal = {{"Excalibur","10","50"},{"Pierre Fal Lial","15","25"},{"Lance de lug","20","30"},{"Chaudron Connaissance","25","35"}};


	//Creation des objets Obstacles
	public Objet createObject(String typeObjet) {
		
		nbCreated++;
		if(((sizeMap - nbCreated) > (DefObjetGraal.length - listeGraal.size())) ){

			if( Math.random() <= (DefObjetGraal.length + ratio*sizeMap)/(sizeMap)){
				//Graal
				if( Math.random() <= DefObjetGraal.length/(sizeMap)){	
					o = createObjectGraal();
				}
				//obstacle
				else {
					//				double x = Math.random();
					//				for (int i=1; i<=DefObjetObstacle.length;i++){
					//					if(x<=(i/DefObjetObstacle.length)){
					//						o = new ObjetObstacle(DefObjetObstacle[i][0],Integer.parseInt(DefObjetObstacle[i][1]));
					//						break;
					//					}
					//				}
				}
			}
			else{
				o = null;
			}
		}
		else{
			o = createObjectGraal();
		}
		//Creation du Chateau
		if (typeObjet.equals("chateau")){
			o = new Chateau(0);

		}

		return o;
	}



	private int objectAfter (int i, ArrayList<ObjetGraal> liste){
		int result = -1;
		Boolean bExiste=false;
		for(ObjetGraal objet :liste){
			if (objet.getType().equals(DefObjetGraal[i][0])){
				if(i==(DefObjetGraal.length)) i=0; 
				result = objectAfter(i++,liste);
				bExiste=true;
				break;
			}
		}
		if(!bExiste){
			result = i;
		}

		return result;

	}

	private ObjetGraal createObjectGraal(){
		ObjetGraal o = null;
		if(listeGraal.size()<4){	
			double x = Math.random();
			for (int i=1; i<=DefObjetGraal.length;i++){
				if(x<= ((double)i)/DefObjetGraal.length){
					int j = objectAfter(i-1,listeGraal);
					o = new ObjetGraal(DefObjetGraal[j][0], Integer.parseInt(DefObjetGraal[j][1]),Integer.parseInt(DefObjetGraal[j][2]));
					listeGraal.add((ObjetGraal) o);
					break;
				}
			}
		}

		return o;
	}











	public ArrayList<ObjetObstacle> getListeObstacle() {
		return listeObstacle;
	}


	public void setListeObstacle(ArrayList<ObjetObstacle> listeObstacle) {
		this.listeObstacle = listeObstacle;
	}


	public ArrayList<ObjetGraal> getListeGraal() {
		return listeGraal;
	}


	public void setListeGraal(ArrayList<ObjetGraal> listeGraal) {
		this.listeGraal = listeGraal;
	}

}
