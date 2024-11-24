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
    private final ArrayList<Deque<Coordinates>> paths = new ArrayList<>();
    private Deque<Coordinates> shortestPath = new ArrayDeque<>();

    public FindPath(Board board) {
        this.board = board;
    }

    private Set<Coordinates> findNeighbours(Coordinates start, Coordinates target, Set<CoordinatesShift> pattern) {
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

    public Deque<Coordinates> BFS(Coordinates start, Coordinates target, Set<CoordinatesShift> movesPattern) {
        queue.add(start);
        visited.add(start);
        parents.put(start, null);

        while (!queue.isEmpty()) {
            Coordinates current = queue.poll();
            if (current.equals(target)) {
                break;
            }
            Set<Coordinates> neighbours = findNeighbours(current, target, movesPattern);
            for (Coordinates next : neighbours) {
                if (!visited.contains(next)) {
                    queue.add(next);
                    visited.add(next);
                    parents.put(next, current);
                }
            }
        }
        if (!visited.contains(target)) {
            shortestPath.clear();
            return shortestPath;

        }
        reverseWay(parents, target);
        findWayToTarget();
        return shortestPath;
    }

    public void reverseWay(Map<Coordinates, Coordinates> way, Coordinates target) {
        Stack<Coordinates> movesBack = new Stack<>();
        Deque<Coordinates> movesForward = new ArrayDeque<>();
        Coordinates current = target;

        if (way.isEmpty()) {
            paths.clear();
        }
        while (current != null) {
            movesBack.push(current);
            current = way.get(current);
        }

        while (!movesBack.isEmpty()) {
            movesForward.addLast(movesBack.pop());
        }

        paths.add(movesForward);
    }

    public void findWayToTarget() {
        if (!paths.isEmpty()) {
            shortestPath = paths.get(0);

            for (Deque<Coordinates> next : paths) {
                if (next.size() < shortestPath.size()) {
                    shortestPath = next;
                }
            }
        }
    }


}
