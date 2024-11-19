package CloneSim.Entities;

import CloneSim.Board.Board;
import CloneSim.Coordinates;
import CloneSim.CoordinatesShift;

import java.util.HashSet;
import java.util.Set;

public class Predator extends Creature {
    private final EntityType target = EntityType.HERBIVORE;
    private final int power;
    public Predator(int health, int speed, int power) {
        super(EntityType.PREDATOR, health, speed);
        this.power = power;
    }
    @Override
    public Set<CoordinatesShift> getCreatureMoves() {
        Set<CoordinatesShift> result = new HashSet<>();
        for (int i = -1; i <= 1; i++) {
            if (i == 0) continue;
            result.add(new CoordinatesShift(i, i));
            result.add(new CoordinatesShift(i,-i));
        }
        return result;
    }

    @Override
    protected boolean isPlaceAvailableForMove(Coordinates coordinates, Board board) {
        return  (board.isEmptyCoordinates(coordinates) || board.getEntity(coordinates).type.equals(target));
    }
}
