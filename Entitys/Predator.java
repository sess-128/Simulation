package simulation.Entitys;

import simulation.CoordinatesShift;

import java.util.HashSet;
import java.util.Set;

public class Predator extends Creature{
    private int attackPower;

    public Predator(Type type) {
        super(type);
    }

    @Override
    public void makeMove() {
        // TODO переместиться или атаковать(herbivore)
    }
    @Override
    public Set<CoordinatesShift> moves () {
        Set<CoordinatesShift> result = new HashSet<>();
        result.add(new CoordinatesShift(1,1));
        result.add(new CoordinatesShift(1,-1));
        result.add(new CoordinatesShift(-1,1));
        result.add(new CoordinatesShift(-1,-1));

        return result;
    }


}
