package Simulation.Entitys;

import Simulation.CoordinatesShift;

import java.util.HashSet;
import java.util.Set;

public interface IPredator {
    default Set<CoordinatesShift> getPredatorMove() {
        Set<CoordinatesShift> result = new HashSet<>();

        //  left to right
        for (int i =-7; i < 7; i++) {
            if (i == 0) continue;
            result.add(new CoordinatesShift(0,i));
        }
        // bot to top
        for (int i =-7; i < 7; i++) {
            if (i == 0) continue;
            result.add(new CoordinatesShift(i,0));
        }

        return result;
    }
}
// пропущена вариация пешки в 3-м уроке, начиная с 46 минуты по 49