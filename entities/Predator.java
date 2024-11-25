package cloneSim.entities;

import cloneSim.board.Board;
import cloneSim.Coordinates;
import cloneSim.CoordinatesShift;

import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Predator extends Creature {
    private final int power;

    public Predator(int health, int speed, int power) {
        super(EntityType.PREDATOR, health, speed);
        this.power = power;
        setTarget(EntityType.HERBIVORE);
    }
    @Override
    public void makeMove(Board board) {
        for (int steps = 0; steps < this.getSpeed(); steps++) {
            Deque<Coordinates> moves = findSteps(board);

            Coordinates start = moves.poll();
            Coordinates nextPosition = moves.poll();

            moveOrAttack(start, nextPosition, board);
        }
        decrementHP();
    }
    @Override
    public Set<CoordinatesShift> getCreatureMoves() {
        Set<CoordinatesShift> result = new HashSet<>();
        for (int i = -1; i <= 1; i++) {
            if (i == 0) continue;
            result.add(new CoordinatesShift(i, i));
            result.add(new CoordinatesShift(i, -i));
        }
        return result;
    }
    private void attack(Creature creature) {
        this.incrementHP();
        creature.decrementHP(power);
    }
    private void moveOrAttack(Coordinates start, Coordinates nextPosition, Board board) {
        Set<Coordinates> targetsCoordinates = getTargetsCoordinates(board);

        boolean isTargetPosition = targetsCoordinates.contains(nextPosition);

        board.remove(start);


        if (isTargetPosition) {
            if (!board.isEmptyCoordinates(nextPosition)) {
                Creature creature = (Creature) board.getEntity(nextPosition);
                attack(creature);
                if (creature.isDead()) {
                    board.add(nextPosition, this);
                } else {
                    board.add(start, this);
                }
            }
        } else {
            board.add(nextPosition, this);
        }
    }

}
