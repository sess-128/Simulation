package CloneSim;

import CloneSim.Board.Board;
import CloneSim.Board.BoardRender;
import CloneSim.Entities.Grass;
import CloneSim.Entities.Herbivore;
import CloneSim.findPath.FindPath;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PatherTester {
    public static void main(String[] args) {
        Board board = new Board();
        BoardRender render = new BoardRender();
        FindPath findPath = new FindPath(board);
        
        board.add(new Coordinates(0,0), new Grass());
        board.add(new Coordinates(6,2), new Herbivore(10,2));
        Set<CoordinatesShift> moves = new HashSet<>();
        for (int i = -1; i <= 1; i++) {
            if (i == 0) continue;
            moves.add(new CoordinatesShift(0, i));
            moves.add(new CoordinatesShift(i,0));
        }

        render.show(board);
        Coordinates grass = new Coordinates(0,0);
        Coordinates herbivore = new Coordinates(6,2);


        Map<Coordinates, Coordinates> bfs = findPath.BFS(herbivore, moves);
        findPath.findWayBack(bfs, grass);
    } 
}
