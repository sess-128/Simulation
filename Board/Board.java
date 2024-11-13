package CloneSim.Board;

import CloneSim.Coordinates;
import CloneSim.Entities.Grass;
import CloneSim.Entities.Tree;
import CloneSim.Factories.Entity;


import java.util.Collection;
import java.util.HashMap;

public class Board {
    private static final int STANDARD_WIDTH = 10, STANDARD_HEIGHT = 10;
    private final int width;
    private final int height;
    private final HashMap<Coordinates, Entity> map;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new HashMap<>();
    }

    public Board() {
        this.width = STANDARD_WIDTH;
        this.height = STANDARD_HEIGHT;
        this.map = new HashMap<>();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void add(Coordinates coordinates, Entity entity) {
        map.put(coordinates, entity);
    }

    public void remove(Coordinates coordinates) {
        map.remove(coordinates);
    }

    public Entity getEntity(Coordinates coordinates) {
        return map.get(coordinates);
    }

    public boolean isEmptyCoordinates(Coordinates coordinates) {
        return !map.containsKey(coordinates);
    }

    public void setStartPosition() {
        map.put(new Coordinates(2, 2), new Grass());
        map.put(new Coordinates(3, 1), new Tree());
    }

    public Collection<Entity> getEntities() {
        return map.values();
    }
}
