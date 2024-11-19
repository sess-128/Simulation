package CloneSim.findPath;

import CloneSim.Board.Board;
import CloneSim.Coordinates;
import CloneSim.CoordinatesShift;
import CloneSim.Entities.Creature;

import java.util.*;

public class FindPath {
    private final Board board;

    public FindPath(Board board) {
        this.board = board;
    }
    public void find(){
        for (Creature creature : board.getCreatures()){
            Coordinates currentCoordinates = creature.getCurrentCoordinates(board);

            Set<CoordinatesShift> patternMoves = creature.getCreatureMoves();
            Set<Coordinates> cells = findNeighboursCells(currentCoordinates, patternMoves);



            for (Coordinates coordinates : cells){
                Set<Coordinates> neighboursCells = findNeighboursCells(coordinates, patternMoves);
            }

        }
    }
    public Set<Coordinates> findNeighboursCells(Coordinates from, Set<CoordinatesShift> pattern){
        Set<Coordinates> neighbourCells = new HashSet<>();

        for (CoordinatesShift shift : pattern) {
            if(from.canShift(shift, board)){
                Coordinates shift1 = from.shift(shift);
                neighbourCells.add(shift1);
            }
        }
        return neighbourCells;
    }
    public Map<Coordinates, Coordinates> solve(Coordinates current){
        Queue<Coordinates> queue = new LinkedList<>();
        queue.add(current);

        Set<Coordinates> visited = new HashSet<>();
        visited.add(current);

        Map<Coordinates, Coordinates> prev = new HashMap<>();

        while (!queue.isEmpty()){
            Set<CoordinatesShift> result = new HashSet<>();
            for (int i = -1; i <= 1; i++) {
                if (i == 0) continue;
                result.add(new CoordinatesShift(0, i));
                result.add(new CoordinatesShift(i,0));
            }

            Coordinates node = queue.poll();
            Set<Coordinates> neighboursCells = findNeighboursCells(current, result);

            for (Coordinates next : neighboursCells){
                if (!visited.contains(next)){
                    queue.add(next);
                    visited.add(next);
                    prev.put(next, node);
                }
            }
        }
        return prev;
    }
}
