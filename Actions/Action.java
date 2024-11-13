package CloneSim.Actions;

import CloneSim.Board.Board;
import CloneSim.Coordinates;
import CloneSim.Entities.Entity;

import java.util.Collection;
import java.util.Random;

public abstract class Action {
    protected final Board board;

    public Action(Board board) {
        this.board = board;
    }

    protected abstract void interact();
    protected void fill(Collection<Entity> entities){
        for (Entity entity : entities) {
            Random random = new Random();
            int randomRow = random.nextInt(board.getHeight() + 1);
            int randomColumn = random.nextInt(board.getWidth() + 1);
            Coordinates randomCoordinates = new Coordinates(randomRow, randomColumn);
            if (board.isEmptyCoordinates(randomCoordinates)) {
                board.add(randomCoordinates, entity);
            } else System.out.println("Ячейка занята");
        }
    }
}
