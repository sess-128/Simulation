package CloneSim.findPath;

import CloneSim.Board.Board;
import CloneSim.Coordinates;
import CloneSim.CoordinatesShift;
import CloneSim.Entities.EntityType;

import java.util.*;

public class FindPath {
    private final Board board;
    private final Queue<Coordinates> queue = new ArrayDeque<>();
    private final Set<Coordinates> visited = new HashSet<>();
    private final Map<Coordinates, Coordinates> parents = new HashMap<>();

    public FindPath(Board board) {
        this.board = board;
    }

    public Set<Coordinates> findNeighbours(Coordinates start, Coordinates target,  Set<CoordinatesShift> pattern) {
        Set<Coordinates> neighbourCells = new HashSet<>();
        EntityType targetType = board.getEntity(target).getType();

        for (CoordinatesShift shift : pattern) {
            if (start.canShift(shift, board)) {
                Coordinates shift1 = start.shift(shift);
                if (board.isEmptyCoordinates(shift1) || board.getEntity(shift1).getType().equals(targetType)) {
                    neighbourCells.add(shift1);
                }
            }
        }
        return neighbourCells;
    }

    public Map<Coordinates, Coordinates> BFS(Coordinates start,Coordinates target, Set<CoordinatesShift> movesPattern) {
        queue.add(start);
        visited.add(start);
        parents.put(start,null);

        while (!queue.isEmpty()){
            Coordinates current = queue.poll();
            Set<Coordinates> neighbours = findNeighbours(current, target, movesPattern);
            for (Coordinates next : neighbours){
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                    parents.put(next, current);
                }
            }
        }
        return parents;
    }

    public Stack<Coordinates> findClosestWay(Map<Coordinates, Coordinates> way, Coordinates end) {
        Stack<Coordinates> movesBack = new Stack<>();
        Coordinates current = end;


        while (current != null) {
            movesBack.push(current);
            current = way.get(current);
        }

        Stack<Coordinates> movesForward = new Stack<>();
        while (!movesBack.isEmpty()){
            movesForward.push(movesBack.pop());
        }

        return movesForward;
    }
}
