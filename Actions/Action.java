package CloneSim.Actions;

import CloneSim.Board.Board;

public abstract class Action {
    protected final Board board;

    public Action(Board board) {
        this.board = board;
    }

    protected abstract void interact();
}
