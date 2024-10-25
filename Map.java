package simulation;

import simulation.Entitys.Entity;

import java.util.HashMap;

public class Map {
    HashMap<Coordinates, Entity> map = new HashMap<>();
    public HashMap<Coordinates, Entity> getMap() {
        return map;
    }
    public void placeEntity (Coordinates coordinates, Entity entity) {
        map.put(coordinates, entity);
    }
    public void removeEntity (Coordinates coordinates) {
        map.remove(coordinates);
    }

    public Entity getEntityByCoordinates (Coordinates coordinates) {
        return map.get(coordinates);
    }
    public boolean isEmptyCoordinate (Coordinates coordinates) {
        return !map.containsKey(coordinates);
    }






}
