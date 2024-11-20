package CloneSim;

import CloneSim.Board.Board;
import CloneSim.Board.BoardRender;
import CloneSim.Entities.Creature;
import CloneSim.Entities.Grass;
import CloneSim.Entities.Herbivore;
import CloneSim.Entities.Tree;
import CloneSim.findPath.FindPath;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PatherTester {
    public static void main(String[] args) {
        Board board = new Board();
        BoardRender render = new BoardRender();
        
        board.add(new Coordinates(0,0), new Grass());
        board.add(new Coordinates(2,0), new Tree());
        board.add(new Coordinates(2,1), new Tree());
        board.add(new Coordinates(2,2), new Tree());
        board.add(new Coordinates(2,3), new Tree());
        board.add(new Coordinates(2,4), new Tree());
        board.add(new Coordinates(6,2), new Herbivore(10,2));

        render.show(board);

        Creature her = (Creature) board.getEntity(new Coordinates(6,2));
        her.makeMoveBFS(board);
//        Set<CoordinatesShift> moves = new HashSet<>();
//        for (int i = -1; i <= 1; i++) {
//            if (i == 0) continue;
//            moves.add(new CoordinatesShift(0, i));
//            moves.add(new CoordinatesShift(i,0));
//        }


//        Coordinates grass = new Coordinates(0,0);
//        Coordinates grass2 = new Coordinates(6,0);
//        Coordinates herbivore = new Coordinates(6,2);
//
//
//        Map<Coordinates, Coordinates> bfs = findPath.BFS(herbivore, grass2, moves);
//        findPath.findClosestWay(bfs, grass2);
    } 
}
