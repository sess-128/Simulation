package CloneSim.Entities;

import CloneSim.Board.Board;
import CloneSim.Coordinates;
import CloneSim.CoordinatesShift;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class Creature extends Entity {
    protected int health;
    protected int speed;

    public Creature(EntityType type, int health, int speed) {
        super(type);
        this.health = health;
        this.speed = speed;
    }

    public void makeMove(Board map) {
        Set<Coordinates> availableMoves = getAvailableMoves(map);

        Coordinates currentCoordinates = getCurrentCoordinates(map);
        Coordinates newCoordinates = getRandomMove(availableMoves, map);

        map.remove(currentCoordinates);
        map.remove(newCoordinates);
        map.add(newCoordinates, this);
    };
    protected abstract boolean isPlaceAvailableForMove(Coordinates coordinates, Board board);
    protected abstract Set<CoordinatesShift> getCreatureMoves();
    private Coordinates getCurrentCoordinates(Board board) {
        for (Coordinates coordinates : board.getBoard().keySet()) {
            if (board.getBoard().get(coordinates) == this) {
                return coordinates;
            }
        }
        return new Coordinates(-1, -1);
    }
    private Coordinates getRandomMove(Set<Coordinates> availableMoves, Board board) {
        Random random = new Random();
        if (availableMoves.size() == 0) return this.getCurrentCoordinates(board);

        int randomIndex = random.nextInt(availableMoves.size());
        return (Coordinates) availableMoves.toArray()[randomIndex];
    }
    private Set<Coordinates> getAvailableMoves(Board board) {
        Coordinates current = getCurrentCoordinates(board);
        Set<CoordinatesShift> shifts = getCreatureMoves();
        Set<Coordinates> availableMoves = new HashSet<>();


        for (CoordinatesShift shift : shifts) {

            if (current.canShift(shift, board)){
                Coordinates newCoordinates = current.shift(shift);
                if (isPlaceAvailableForMove(newCoordinates, board)){
                    availableMoves.add(newCoordinates);
                }
            }
        }
        return availableMoves;
    }
}
