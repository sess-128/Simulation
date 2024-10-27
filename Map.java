package simulation;

import simulation.Entitys.*;

import java.util.HashMap;

public class Map {
    HashMap<Coordinates, Entity> map = new HashMap<>();

    public HashMap<Coordinates, Entity> getMap() {
        return map;
    }

    public void placeEntity(Coordinates coordinates, Entity entity) {
        map.put(coordinates, entity);
    }

    public void setCheckPos() {
        map.put(new Coordinates(1, 1), new Predator(Type.Predator));
        map.put(new Coordinates(3, 2), new Herbivore(Type.Herbivore));
        map.put(new Coordinates(5, 3), new Rock(Type.Rock));
        map.put(new Coordinates(7, 4), new Grass(Type.Grass));
        map.put(new Coordinates(8, 10), new Tree(Type.Tree));

    }

    public void removeEntity(Coordinates coordinates) {
        map.remove(coordinates);
    }

    public Entity getEntityByCoordinates(Coordinates coordinates) {
        return map.get(coordinates);
    }

    public boolean isEmptyCoordinate(Coordinates coordinates) {
        return !map.containsKey(coordinates);
    }


}
