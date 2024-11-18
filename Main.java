package CloneSim;

import CloneSim.Actions.InitActions.FillMap;
import CloneSim.Actions.TurnActions.RefillMap;
import CloneSim.Board.Board;
import CloneSim.Board.BoardRender;
import CloneSim.Entities.Creature;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Board board = new Board();
        BoardRender render = new BoardRender();

        RefillMap refillMap = new RefillMap(board);
        FillMap init = new FillMap(board);

        init.interact();
        render.show(board);
        while (true) {
            for (Creature creature : board.getCreatures()) {
//                for (int i = 0; i < creature.getSpeed(); i++) {
                    creature.makeMove(board);

                    render.show(board);
                    System.out.println("----------");



                        if (creature.isDead()){
                            board.remove(creature.getCurrentCoordinates(board));
                            System.out.println("Все существа удалены");
                        }
                    }

                Thread.sleep(2000);
//                }

            refillMap.interact();
        }


    }
}
