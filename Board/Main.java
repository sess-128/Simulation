package CloneSim.Board;

import CloneSim.Actions.InitActions.FillMap;
import CloneSim.Actions.TurnActions.RefillAction;
import CloneSim.Entities.Creature;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board();
        BoardRender render = new BoardRender();

        RefillAction refillAction = new RefillAction(board);
        FillMap init = new FillMap(board);

        init.interact();
        render.show(board);
        while (true) {
            for (Creature creature : board.getCreatures()){
                creature.makeMove(board);
            }
            refillAction.interact();
            System.out.println("----------");
            render.show(board);

            Thread.sleep(1000);
        }





    }
}
