package CloneSim.Entities;

import CloneSim.Board.Board;
import CloneSim.Coordinates;
import CloneSim.CoordinatesShift;

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
        Deque<Coordinates> moves = findSteps(board);

        Coordinates start = moves.poll();
        Entity entity = board.getEntity(start);

        board.remove(start);

        Coordinates nextPosition = moves.poll();
        Set<Coordinates> targetsCoordinates = getTargetsCoordinates(board);


        if (targetsCoordinates.contains(nextPosition)){
            eat();
        }
        board.add(nextPosition, entity);
    }
    public void eat(){
        System.out.println("Я поел как зайчик");
        incrementHP();
    }
}
