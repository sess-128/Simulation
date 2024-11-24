package CloneSim.Entities;

import CloneSim.Board.Board;
import CloneSim.Coordinates;
import CloneSim.CoordinatesShift;

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
        Deque<Coordinates> moves = findSteps(board);

        Coordinates start = moves.poll();
        Coordinates nextPosition = moves.poll();


        Set<Coordinates> targetsCoordinates = getTargetsCoordinates(board);


        boolean isTargetPosition = targetsCoordinates.contains(nextPosition);

        board.remove(start);

        if (isTargetPosition) {

            Creature creature = (Creature) board.getEntity(nextPosition);
            attack();
            incrementHP();
            creature.decrementHP(power);
            System.out.println("Была атака");

            if (creature.isDead()) {
                System.out.println("Заяц умер");
                board.add(nextPosition, this);

            } else {
                System.out.println("Заяц не умер");
                board.add(start, this);
            }
        } else {
            System.out.println("Зайца нет рядом");
            board.add(nextPosition, this);
        }
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

    public void attack() {
        System.out.println("Я атаковал как волк");
    }

    public void targetAround(Board board){
        Set<CoordinatesShift> creatureMoves = getCreatureMoves();
        Coordinates current = getCurrentCoordinates(board);

        for (CoordinatesShift creatureMove : creatureMoves) {
            board.getEntity(current.shift(creatureMove)).getType().equals(this.getTarget());
        }

    }
}
