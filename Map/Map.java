package Simulation.Map;

import Simulation.Coordinates;
import Simulation.Entity;
import Simulation.Form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Map {
    public final String startingFen;
    public HashMap<Coordinates, Entity> entitys = new HashMap<>();

    public List<Move> moves = new ArrayList<>();

    public Map(String startingFen) {
        this.startingFen = startingFen;
    }

    public void setEntitys(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        entitys.put(coordinates,entity);
    }

    public void removeEntity(Coordinates coordinates) {
        entitys.remove(coordinates);
    }

    public void makeMove(Move move){
        Entity entity = getEntity(move.from);
        removeEntity(move.from);
        setEntitys(move.to, entity);

        moves.add(move);
    }

//    public void setupDefaultEntitysPosition(){
//        setEntitys(new Coordinates(2,7), new Tree(Form.TREE,new Coordinates(2,7)));
//        setEntitys(new Coordinates(10,6), new Grab(Form.GRAB,new Coordinates(10,6)));
//        setEntitys(new Coordinates(1,1), new Rock(Form.ROCK,new Coordinates(1,1)));
//        setEntitys(new Coordinates(10,10), new Predator(Form.PREDATOR,new Coordinates(10,10)));
//        setEntitys(new Coordinates(4,4), new Predator(Form.PREDATOR,new Coordinates(4,4)));
//        setEntitys(new Coordinates(8,8),new Herbivore(Form.HERBIVORE,new Coordinates(8,8)));
//    }
    public Entity getEntity  (Coordinates coordinates){
        return entitys.get(coordinates);
    }

    public boolean isSquareEmpty (Coordinates coordinates){
        return !entitys.containsKey(coordinates);
    }


    public boolean isSquareAttackedByForm(Coordinates coordinates, Form form) {
        List<Entity> entities = getEntitiesByForm(form);

        for (Entity entity : entities) {
            Set<Coordinates> attackedSquares = entity.getAttackedSquares(this);

            if (attackedSquares.contains(coordinates)){
                return true;
            }
        }
        return false;
    }

    public List<Entity> getEntitiesByForm(Form form) {
        List<Entity> result = new ArrayList<>();

        for (Entity entity : entitys.values()){
            if (entity.form == form){
                result.add(entity);
            }
        }
        return result;
    }
}
