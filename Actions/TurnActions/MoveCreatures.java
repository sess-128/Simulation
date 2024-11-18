package CloneSim.Actions.TurnActions;

import CloneSim.Actions.Action;
import CloneSim.Board.Board;
import CloneSim.Entities.Creature;

public class MoveCreatures extends Action {
    public MoveCreatures(Board board) {
        super(board);
    }

    @Override
    public void interact() {
        for (Creature creature : board.getCreatures()){
            creature.makeMove(board);
        }
    }
}
