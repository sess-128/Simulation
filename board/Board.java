package cloneSim.board;

import cloneSim.Coordinates;
import cloneSim.entities.Creature;
import cloneSim.entities.Entity;
import cloneSim.entities.Ground;

import java.util.*;

public class Board {
    private static final int STANDARD_WIDTH = 10, STANDARD_HEIGHT = 10;
    private final int width;
    private final int height;
    private final HashMap<Coordinates, Entity> board;
    public Board() {
        this.width = STANDARD_WIDTH;
        this.height = STANDARD_HEIGHT;
        this.board = new HashMap<>();
    }

    public HashMap<Coordinates, Entity> getBoard() {
        return board;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void add(Coordinates coordinates, Entity entity) {
        board.put(coordinates, entity);
    }

    public void remove(Coordinates coordinates) {
        board.remove(coordinates);
    }

    public Entity getEntity(Coordinates coordinates) {
        if (!board.containsKey(coordinates)) return new Ground() {
        };
        return board.get(coordinates);
    }

    public boolean isEmptyCoordinates(Coordinates coordinates) {
        return !board.containsKey(coordinates);
    }

    public Collection<Entity> getAllEntities() {
        return board.values();
    }

    public List<Creature> getCreatures() {
        List<Creature> creatures = new ArrayList<>();
        for (Entity entity : board.values()) {
            if (entity instanceof Creature) {
                creatures.add((Creature) entity);
            }
        }
        return creatures;
    }

    public Set<Coordinates> getAllCoordinates(){
        return board.keySet();
    }
}
