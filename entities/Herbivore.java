package cloneSim.entities;

import cloneSim.board.Board;
import cloneSim.Coordinates;
import cloneSim.CoordinatesShift;

import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Herbivore extends Creature {
    public Herbivore(int health, int speed) {
        super(EntityType.HERBIVORE, health, speed);
        setTarget(EntityType.GRASS);
    }

    @Override
    public Set<CoordinatesShift> getCreatureMoves() {
        Set<CoordinatesShift> result = new HashSet<>();
        for (int i = -1; i <= 1; i++) {
            if (i == 0) continue;
            result.add(new CoordinatesShift(0, i));
            result.add(new CoordinatesShift(i, 0));
        }
        return result;
    }
    @Override
    public void makeMove(Board board) {
        for (int steps = 0; steps < this.getSpeed(); steps++) {
            Deque<Coordinates> moves = findSteps(board);

            Coordinates start = moves.poll();
            Coordinates nextPosition = moves.poll();

            moveAndEat(start, nextPosition, board);


        }
        decrementHP();
    }

    private void eat() {
        this.incrementHP();
    }

    private void moveAndEat(Coordinates start, Coordinates nextPosition, Board board) {
        Entity entity = board.getEntity(start);

        board.remove(start);


        Set<Coordinates> targetsCoordinates = getTargetsCoordinates(board);


        if (targetsCoordinates.contains(nextPosition)) {
            eat();
        }
        board.add(nextPosition, entity);
    }

}
