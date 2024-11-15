package CloneSim.Board;

import CloneSim.Coordinates;
import CloneSim.Entities.Creature;
import CloneSim.Entities.Entity;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Board {
    private static final int STANDARD_WIDTH = 10, STANDARD_HEIGHT = 10;
    private final int width;
    private final int height;

    public HashMap<Coordinates, Entity> getBoard() {
        return board;
    }

    private final HashMap<Coordinates, Entity> board;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.board = new HashMap<>();
    }

    public Board() {
        this.width = STANDARD_WIDTH;
        this.height = STANDARD_HEIGHT;
        this.board = new HashMap<>();
    }

    public int  getHeight() {
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
        return board.get(coordinates);
    }

    public boolean isEmptyCoordinates(Coordinates coordinates) {
        return !board.containsKey(coordinates);
    }

    public Collection<Entity> getEntities() {
        return board.values();
    }

    public List<Creature> getCreatures(){
        List<Creature> creatures = new ArrayList<>();
        for (Entity entity : board.values()){
            if (entity instanceof Creature){
                creatures.add((Creature) entity);
            }
        }
        return creatures;
    }
}
