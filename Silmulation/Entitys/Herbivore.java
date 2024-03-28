package Silmulation.Entitys;

import Silmulation.CoordinatesShift;
import Silmulation.Form;
import Silmulation.Coordinates;
import Silmulation.Entity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Herbivore extends Entity {
    public Herbivore(Form form, Coordinates coordinates) {
        super(form, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getEntityMove() {
        return new HashSet<>(Arrays.asList(
                new CoordinatesShift(1,1),
                new CoordinatesShift(2,2),

                new CoordinatesShift(-1,1),
                new CoordinatesShift(-2,2),

                new CoordinatesShift(1,-1),
                new CoordinatesShift(2,-2),

                new CoordinatesShift(-1,-1),
                new CoordinatesShift(-2,-2)
        ));
    }
}
