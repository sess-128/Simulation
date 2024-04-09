package Simulation.Entitys;

import Simulation.CoordinatesShift;

import java.util.HashSet;
import java.util.Set;

public interface IHerbivore {
    default Set<CoordinatesShift>  getHerbivoreMove() {
        Set<CoordinatesShift> result = new HashSet<>();

        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;
            result.add(new CoordinatesShift(i,i));
        }
        for (int i = -7; i <= 7; i++) {
            if (i == 0) continue;
            result.add(new CoordinatesShift(i,-i));
        }
        return result;
    }
}
