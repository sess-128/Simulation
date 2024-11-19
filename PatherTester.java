package CloneSim;

import CloneSim.Board.Board;
import CloneSim.Board.BoardRender;
import CloneSim.Entities.Grass;
import CloneSim.Entities.Herbivore;
import CloneSim.findPath.FindPath;

public class PatherTester {
    public static void main(String[] args) {
        Board board = new Board();
        BoardRender render = new BoardRender();
        
        board.add(new Coordinates(0,0), new Grass());
        board.add(new Coordinates(3,3), new Herbivore(10,2));

        render.show(board);
        FindPath findPath = new FindPath(board);
        findPath.find();
    } 
}
