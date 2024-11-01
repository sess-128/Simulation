package simulation.Entitys;

import simulation.CoordinatesShift;

import java.util.HashSet;
import java.util.Set;

public class Herbivore extends Creature{
    public Herbivore(Type type) {
        super(type);
    }

    @Override
    public void makeMove() {
    }
    @Override
    public Set<CoordinatesShift> moves () {
        Set<CoordinatesShift> result = new HashSet<>();
        result.add(new CoordinatesShift(0,1));
        result.add(new CoordinatesShift(0,-1));
        result.add(new CoordinatesShift(1,0));
        result.add(new CoordinatesShift(-1,0));

        return result;
    }

}
