package controleur;

import java.util.ArrayList;
import model.*;

public class FactoryObjet {



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
	public static final String[][] DefObjetGraal = {{"Excalibur","10","50"},{"Pierre_Fal_Lial","15","25"},{"Lance_de_lug","20","30"},{"Chaudron_Connaissance","25","35"}};


	//Creation des objets
	public Objet createObject(String typeObjet) {

		nbCreated++;
		Objet o = null;
		//Si on à tiré la moitié de la map on crée un chateau
		if(nbCreated == sizeMap/2) return o = new Chateau(0);
		
		// On test si il y a plus de place sur la map que de nombre d'objet graal à poser.
		else if(((sizeMap - nbCreated) >= (DefObjetGraal.length - listeGraal.size())) ){
			
			//calcul de la probabilité de créer un objet sur la map
			if( Math.random() <= ((double)(DefObjetGraal.length + ratio*sizeMap))/(sizeMap)){
				//calcul de la probabilité de créer un objet graal sur la map
				if( Math.random() <= ((double)DefObjetGraal.length)/(sizeMap)){	
					o = createObjectGraal();
				}
				//calcul de la probabilité de créer un objet obstacle sur la map
				else {
					double x = Math.random();
					//génération aléatoire des objets obstacles
					for (int i=0; i<DefObjetObstacle.length;i++){
						if(x<=((double)(i+1)/DefObjetObstacle.length)){
							o = new ObjetObstacle(DefObjetObstacle[i][0],Integer.parseInt(DefObjetObstacle[i][1]));
							break;
						}
					}
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
			

		}

		return o;
	}



	private int objectNextFree (int i, ArrayList<ObjetGraal> liste){
		int result = -1;
		Boolean bExiste=false;
		for(ObjetGraal objet :liste){
			if (objet.getType().equals(DefObjetGraal[i][0])){

				if(i==(DefObjetGraal.length-1)) i=0;
				else i++;
				result = objectNextFree(i,liste);
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
			for (int i=0; i<DefObjetGraal.length;i++){
				if(x<= ((double)(i+1))/DefObjetGraal.length){
					int j = objectNextFree(i,listeGraal);
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
