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
    public Map<Coordinates, Coordinates> BFS(Coordinates start, Set<CoordinatesShift> movesPattern){
        queue.add(start);
        visited.add(start);
        parents.put(start,null);

        while (!queue.isEmpty()){
            Coordinates current = queue.poll();
            Set<Coordinates> neighbours = findNeighbours(current,movesPattern);
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

    /**
     *  Текущая - 2.2
     *  Получаем соседей
     *  Для каждого соседа записываем что его родитель -> текущая
     *  map.put(сосед, текущая)
     */
    public void findWayBack(Map<Coordinates, Coordinates> way, Coordinates end) {
        Stack<Coordinates> movesBack = new Stack<>();
        Coordinates current = end;
        int movesCounter = 0;
        
        while (current!=null){
            movesBack.push(current);
            current = way.get(current);
            movesCounter++;
        }

        while (!movesBack.isEmpty()){
            System.out.print(movesBack.pop());
            if (!movesBack.isEmpty()){
                System.out.print("->");
            }
        }

        System.out.println("Пройдено узлов: " + movesCounter);
    }
}
