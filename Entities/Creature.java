package CloneSim.Entities;

import CloneSim.Board.Board;
import CloneSim.Coordinates;
import CloneSim.CoordinatesShift;
import CloneSim.findPath.FindPath;

import java.util.*;

public abstract class Creature extends Entity {
    private static final int DEAD_HEALTH = 0;
    private final int speed;
    private int health;
    private EntityType target;


    public Creature(EntityType type, int health, int speed) {
        super(type);
        this.health = health;
        this.speed = speed;
    }

    public void makeMove(Board board) {
        Deque<Coordinates> moves = findSteps(board);

        Coordinates start = moves.poll();
        Entity entity = board.getEntity(start);




        board.remove(start);


        Coordinates nextPosition = moves.poll();
        Set<Coordinates> targetsCoordinates = getTargetsCoordinates(board);


        if (targetsCoordinates.contains(nextPosition)){
            if (this instanceof Herbivore){

            }
            if (this instanceof Predator){

            }
        }
        board.add(nextPosition, entity);



    }

    public Deque<Coordinates> findSteps(Board board) {
        FindPath findPath = new FindPath(board);

        Set<Coordinates> targetsCoordinates = getTargetsCoordinates(board);
        Coordinates current = getCurrentCoordinates(board);
        Set<CoordinatesShift> moves = getCreatureMoves();

        Deque<Coordinates> steps;


        for (Coordinates target : targetsCoordinates) {
            steps = findPath.BFS(current, target, moves);
            if (!steps.isEmpty()) {
                return steps;
            }
        }

        Coordinates randomMove = getRandomMove(getAvailableMoves(board), board);
        steps = new ArrayDeque<>();

        steps.push(randomMove);
        steps.push(current);

        return steps;
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

    protected Set<Coordinates> getAvailableMoves(Board board) {
        Coordinates current = getCurrentCoordinates(board);
        Set<Coordinates> availableMoves = new HashSet<>();
        for (CoordinatesShift shift : getCreatureMoves()) {
            if (current.canShift(shift, board)) {
                Coordinates shift1 = current.shift(shift);
                if (board.isEmptyCoordinates(shift1) || board.getEntity(shift1).getType().equals(target)) {
                    availableMoves.add(shift1);
                }
            }
        }
        return availableMoves;
    }

    protected void setTarget(EntityType target) {
        this.target = target;
    }
    public EntityType getTarget(){
        return target;
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

}
