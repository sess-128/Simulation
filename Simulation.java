package CloneSim;

import CloneSim.Actions.InitActions.FillMap;
import CloneSim.Actions.TurnActions.MoveCreatures;
import CloneSim.Actions.TurnActions.RefillMap;
import CloneSim.Board.Board;
import CloneSim.Board.BoardRender;

public class Simulation {
    public static final int MOVE_COUNTER = 0;
    private final Board board;
    private final BoardRender boardRender;
    private final FillMap fillMap;
    private final MoveCreatures moveCreatures;
    private final RefillMap refillMap;

    public Simulation() {
        this.board = new Board();
        this.boardRender = new BoardRender();
        this.fillMap = new FillMap(board);
        this.moveCreatures = new MoveCreatures(board);
        this.refillMap = new RefillMap(board);
    }

    public void nextTurn(){
        boardRender.show(board);
        moveCreatures.interact();
        refillMap.interact();
    }
    public void startSimulation() throws InterruptedException {
        fillMap.interact();
        while (true) {
            boardRender.show(board);
            moveCreatures.interact();
            refillMap.interact();
            Thread.sleep(2000);
        }
    }
    public void pauseSimulation(){
        
    }
}
