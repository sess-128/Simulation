package Silmulation;

import Silmulation.Entitys.*;

import java.util.HashMap;

public class Map {
    HashMap<Coordinates, Entity> entitys = new HashMap<>();

    public void setEntitys(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        entitys.put(coordinates,entity);
    }

    public void removeEntity(Coordinates coordinates) {
        entitys.remove(coordinates);
    }

    public void moveEntity(Coordinates from, Coordinates to){
        Entity entity = getEntity(from);
        removeEntity(from);
        setEntitys(to, entity);
    }

    public void setupDefaultEntitysPosition(){
        setEntitys(new Coordinates(2,7), new Tree(Form.TREE,new Coordinates(2,7)));
        setEntitys(new Coordinates(10,6), new Grab(Form.GRAB,new Coordinates(10,6)));
        setEntitys(new Coordinates(1,1), new Rock(Form.ROCK,new Coordinates(1,1)));
        setEntitys(new Coordinates(10,10), new Predator(Form.PREDATOR,new Coordinates(10,10)));
        setEntitys(new Coordinates(4,4), new Predator(Form.PREDATOR,new Coordinates(4,4)));
        setEntitys(new Coordinates(8,8),new Herbivore(Form.HERBIVORE,new Coordinates(8,8)));
    }
    public Entity getEntity  (Coordinates coordinates){
        return entitys.get(coordinates);
    }

    public boolean isSquareEmpty (Coordinates coordinates){
        return !entitys.containsKey(coordinates);
    }


}
