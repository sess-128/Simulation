package CloneSim.Entities;

import CloneSim.Board.Board;
import CloneSim.Coordinates;
import CloneSim.CoordinatesShift;
import CloneSim.findPath.FindPath;

import java.util.*;

public abstract class Creature extends Entity {
    private static final int DEAD_HEALTH = 0;
    private int health;
    private final int speed;
    private EntityType target;


    public Creature(EntityType type, int health, int speed) {
        super(type);
        this.health = health;
        this.speed = speed;
    }

    public void makeMove(Board board) {
        for (int i = 0; i < speed; i++) {
            Set<Coordinates> availableMoves = getAvailableMoves(board);

            Coordinates currentCoordinates = getCurrentCoordinates(board);
            Coordinates newCoordinates = getRandomMove(availableMoves, board);

            board.remove(currentCoordinates);
            board.remove(newCoordinates);
            board.add(newCoordinates, this);

            decrementHP();
        }
    }

    public void makeMoveBFS(Board board) {
        FindPath findPath = new FindPath(board);
        Coordinates current = getCurrentCoordinates(board);
        Set<CoordinatesShift> moves = getCreatureMoves();

        Deque<Coordinates> bfs = new ArrayDeque<>();

        for (Coordinates target : getTargetsCoordinates(board)) {
            bfs = findPath.BFS(current, target, moves);

        }
        System.out.println(bfs);
    }

    private Set<Coordinates> getTargetsCoordinates(Board board) {
        Set<Coordinates> targetCoordinates = new HashSet<>();

        for (Coordinates coordinates : board.getBoard().keySet()) {
            if (board.getEntity(coordinates).type.equals(target)) {
                targetCoordinates.add(coordinates);
            }
        }
        return targetCoordinates;
    }


    public abstract boolean isPlaceAvailableForMove(Coordinates coordinates, Board board);

    public abstract Set<CoordinatesShift> getCreatureMoves();

    public Coordinates getCurrentCoordinates(Board board) {
        Coordinates current = new Coordinates(0, 0);
        for (Coordinates coordinates : board.getBoard().keySet()) {
            if (board.getBoard().get(coordinates) == this) {
                current = coordinates;
                return current;
            }
        }
        return current;
    }

    private Coordinates getRandomMove(Set<Coordinates> availableMoves, Board board) {
        Random random = new Random();
        if (availableMoves.size() == 0) return this.getCurrentCoordinates(board);

        int randomIndex = random.nextInt(availableMoves.size());
        return (Coordinates) availableMoves.toArray()[randomIndex];
    }

    public Set<Coordinates> getAvailableMoves(Board board) {
        Coordinates current = getCurrentCoordinates(board);
        Set<CoordinatesShift> shifts = getCreatureMoves();
        Set<Coordinates> availableMoves = new HashSet<>();


        for (CoordinatesShift shift : shifts) {
            if (current.canShift(shift, board)) {
                Coordinates newCoordinates = current.shift(shift);
                if (isPlaceAvailableForMove(newCoordinates, board)) {
                    availableMoves.add(newCoordinates);
                }
            }
        }

        return availableMoves;
    }

    public void setTarget(EntityType target) {
        this.target = target;
    }

    public EntityType getTarget() {
        return target;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    //TODO ЛОГИКА ЕДЫ


    public void decrementHP() {
        health--;
    }

    public void incrementHP() {
        health++;
    }

    public boolean isDead() {
        return health == DEAD_HEALTH;
    }

    private void eat(Board board) {
        if (getTargetsCoordinates(board).isEmpty()) {
            makeMove(board);
        } else {

        }
    }
}
