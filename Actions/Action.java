package CloneSim.Actions;

import CloneSim.Board.Board;
import CloneSim.Coordinates;
import CloneSim.Entities.Entity;

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

            Coordinates randomed = getRandomCoordinates();

            while (board.isEmptyCoordinates(randomed)) {
                board.add(randomed, entity);
            }
        }
    }

    private Coordinates getRandomCoordinates() {
        int randomRow = random.nextInt(board.getHeight());
        int randomColumn = random.nextInt(board.getWidth());
        return new Coordinates(randomRow, randomColumn);
    }
}
