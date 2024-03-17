package Silmulation;

import Silmulation.Entitys.Tree;

import java.util.HashMap;

public class Map {
    HashMap<Coordinates, Entity> entitys = new HashMap<>();

    public void setEntitys(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        entitys.put(coordinates,entity);
    }

    public void setupDefaultEntitysPosition(){
        for (Hori hori: Hori.values()){
            setEntitys(new Coordinates(hori,2), new Tree(Color.GREEN,new Coordinates(hori,2)));
            setEntitys(new Coordinates(hori,7), new Tree(Color.RED,new Coordinates(hori,7)));
        }
    }
}
