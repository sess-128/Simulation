package cloneSim.actions.turnActions;

import cloneSim.actions.Action;
import cloneSim.board.Board;
import cloneSim.entities.Creature;
import cloneSim.entities.Entity;

import java.util.ArrayList;
import java.util.List;

public class MoveCreatures extends Action {
    public MoveCreatures(Board board) {
        super(board);
    }

    @Override
    public void interact() {
        List<Creature> creatures = new ArrayList<>();
        for (Entity entity : board.getAllEntities()) {
            if (entity instanceof Creature) {
                creatures.add((Creature) entity);
            }
        }
        for (Creature creature : creatures) {
            creature.makeMove(board);

        }
    }
}
