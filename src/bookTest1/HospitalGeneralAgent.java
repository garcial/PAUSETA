package bookTest1;

import java.io.IOException;
import java.util.ArrayList;

import needAGoodName.Agency;
import needAGoodName.Resource;
import enviroment.Location;
import enviroment.Map;
import jade.core.Agent;
import jadeBehaviours.PAUSETARegisterBehaviour;

public class HospitalGeneralAgent extends Agent {

	private static final long serialVersionUID = 8293492758491163351L;

	protected void setup(){
		
		Map map = null;

		try {
			
			map = new Map("map/test1");
		} catch (IOException e) {
			
			System.out.println("Error al leer el fichero del mapa.");
			e.printStackTrace();
		}
		
		Location location = new Location();
		location.segment = map.getIntersectionByID("Hospital general").out.get(0);
		location.position = 0;
		
		Agency agency = new Agency("Hospital general", "Descripcion hospital", "Otra cosa", location, new ArrayList<Resource>());
		
		//Ponemos los recursos
		ArrayList<Resource> resources = new ArrayList<Resource>();
		
		resources.add(new Resource("Ambulancia atencion urgente", agency, location, 0));
		resources.add(new Resource("Ambulancia atencion urgente", agency, location, 0));
		resources.add(new Resource("Ambulancia de ayuda y evacuacion", agency, location, 0));
		resources.add(new Resource("Ambulancia de ayuda y evacuacion", agency, location, 0));
		resources.add(new Resource("Medico", agency, location, 0));
		resources.add(new Resource("Medico", agency, location, 0));

		for(int i = 0; i < resources.size(); i++){
			
			agency.addResource(resources.get(i));
		}

		PAUSETARegisterBehaviour behaviour = new PAUSETARegisterBehaviour(this, agency, 1, 0, map);
		
		this.addBehaviour(behaviour);
	}
}
