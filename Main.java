package CloneSim;

import CloneSim.Actions.InitActions.FillMap;
import CloneSim.Actions.TurnActions.MoveCreatures;
import CloneSim.Board.Board;
import CloneSim.Board.BoardRender;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        BoardRender render = new BoardRender();
        FillMap fillMap = new FillMap(board);
        MoveCreatures moveCreatures = new MoveCreatures(board);


        fillMap.interact();
        moveCreatures.interact();
        render.show(board);
    }
}
