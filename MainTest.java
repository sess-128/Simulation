package CloneSim;

import CloneSim.Actions.InitActions.FillMap;
import CloneSim.Actions.TurnActions.MoveCreatures;
import CloneSim.Actions.TurnActions.RefillMap;
import CloneSim.Board.Board;
import CloneSim.Board.BoardRender;

public class MainTest {
    public static void main(String[] args) throws InterruptedException {

        Simulation simulation = new Simulation();
        simulation.startSimulation();



    }
//        Board board = new Board();
//        BoardRender boardRender = new BoardRender();
//        FillMap fillMap = new FillMap(board);
//        RefillMap refillMap = new RefillMap(board);
//        MoveCreatures moveCreatures = new MoveCreatures(board);
//
//        fillMap.interact();
//        while (true) {
//            moveCreatures.interact();
//
//
////                if (creature.isDead()){
////                    board.remove(creature.getCurrentCoordinates(board));
////                    System.out.println("Удалено существо: " + creature);
////
//
//
//            boardRender.show(board);
//            Thread.sleep(1000);
//            refillMap.interact();
//
//        }
//    }
}
