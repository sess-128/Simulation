package CloneSim.findPath;

import CloneSim.Board.Board;
import CloneSim.Coordinates;
import CloneSim.CoordinatesShift;

import java.util.*;

public class FindPath {
    private final Board board;
    private final Queue<Coordinates> queue = new ArrayDeque<>();
    private final Set<Coordinates> visited = new HashSet<>();
    private final Map<Coordinates, Coordinates> parents = new HashMap<>();

    public FindPath(Board board) {
        this.board = board;
    }

    public Set<Coordinates> findNeighbours(Coordinates start, Set<CoordinatesShift> pattern){
        Set<Coordinates> neighbourCells = new HashSet<>();

        for (CoordinatesShift shift : pattern) {
            if(start.canShift(shift, board)){
                Coordinates shift1 = start.shift(shift);
                neighbourCells.add(shift1);
            }
        }
        return neighbourCells;
    }
    public void BFS(Coordinates start, Set<CoordinatesShift> movesPattern){
        Coordinates current = start;
        Set<Coordinates> neighbours = findNeighbours(current, movesPattern);

        queue.add(current);
        visited.add(current);
        parents.put(current,null);

        while (!queue.isEmpty()){
            for (Coordinates next : neighbours){
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                    parents.put(next, current);

                    current = next;
                    neighbours = findNeighbours(next,movesPattern);

                }
            }
            queue.poll();
        }
        System.out.println("Очередь" + queue);
        System.out.println("Посещенные" + visited);
        System.out.println("Родители" + parents);

    }
}
