package simulation;

import simulation.Entitys.Creature;
import simulation.Entitys.Entity;
import simulation.Entitys.Type;
import simulation.Map.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Overseer {

    private final Map map;

    public Overseer(Map map) {
        this.map = map;
    }

    public List<Coordinates> getCoordinatesByType(Type entityType) {
        List<Coordinates> entities = new ArrayList<>();

        for (Coordinates coordinates : map.getMap().keySet()) {
            Entity entity = map.getEntityByCoordinates(coordinates);
            if (entity.getType().equals(entityType)) {
                entities.add(coordinates);
            }
        }
        return entities;
    }

    public void calcMoves(Creature creature) {
        Set<CoordinatesShift> shifts = creature.moves();
        List<Coordinates> coordinatesByType = getCoordinatesByType(creature.getType());

        for (Coordinates coordinates : coordinatesByType) {
            for (CoordinatesShift coordinatesShift : shifts) {

                if(coordinates.canShift(coordinatesShift)){
                    coordinates.shift(coordinatesShift);
                } else {
                    
                }

            }
        }



    }


}
