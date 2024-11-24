package CloneSim.Entities;

import CloneSim.Board.Board;
import CloneSim.CoordinatesShift;

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

    public void eat(){
        System.out.println("Я поел как зайчик");
        incrementHP();
    }
}
