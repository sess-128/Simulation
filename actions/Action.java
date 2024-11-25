package cloneSim.actions;

import cloneSim.board.Board;
import cloneSim.Coordinates;
import cloneSim.entities.Entity;

import java.util.Collection;
import java.util.Random;

public abstract class Action {
    protected final Board board;
    private final Random random = new Random();

    public Action(Board board) {
        this.board = board;
    }

    protected abstract void interact();

    protected void fill(Collection<Entity> entities) {
        for (Entity entity : entities) {

            Coordinates randomCoordinates = getRandomCoordinates();

            while (board.isEmptyCoordinates(randomCoordinates)) {
                board.add(randomCoordinates, entity);
            }
        }
    }

    private Coordinates getRandomCoordinates() {
        int randomRow = random.nextInt(board.getHeight());
        int randomColumn = random.nextInt(board.getWidth());
        return new Coordinates(randomRow, randomColumn);
    }
}
