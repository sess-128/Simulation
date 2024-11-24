package CloneSim;

import CloneSim.Actions.TurnActions.MoveCreatures;
import CloneSim.Board.Board;
import CloneSim.Board.BoardRender;
import CloneSim.Entities.*;

import java.util.HashMap;

public class PatherTester {
    public static void main(String[] args) {
        Board board = new Board(3,3);
        BoardRender render = new BoardRender();

//        board.add(new Coordinates(0,0), new Grass());
//        board.add(new Coordinates(1,3), new Grass());
//        board.add(new Coordinates(2,0), new Tree());
//        board.add(new Coordinates(2,1), new Tree());
//        board.add(new Coordinates(2,2), new Tree());
//        board.add(new Coordinates(2,3), new Tree());
//        board.add(new Coordinates(1,3), new Grass());
//        board.add(new Coordinates(5,4), new Herbivore(5,5));
        MoveCreatures moveCreatures = new MoveCreatures(board);



        board.add(new Coordinates(2,2), new Herbivore(5,5));
//        board.add(new Coordinates(8,4), new Herbivore(5,5));
        board.add(new Coordinates(0,0), new Predator(10,2, 5));

        render.show(board);
        System.out.println("-------------");
        moveCreatures.interact();
        render.show(board);
        System.out.println("-------------");
        moveCreatures.interact();
        render.show(board);
        System.out.println("-------------");
        moveCreatures.interact();
        render.show(board);
        System.out.println("-------------");
        moveCreatures.interact();
        render.show(board);
        System.out.println("-------------");
        moveCreatures.interact();
        render.show(board);
        System.out.println("-------------");
        moveCreatures.interact();
        render.show(board);
        System.out.println("-------------");
        moveCreatures.interact();
        render.show(board);
        System.out.println("-------------");
        moveCreatures.interact();
        render.show(board);
        System.out.println("-------------");
        moveCreatures.interact();
        render.show(board);
        System.out.println("-------------");

    }
}
