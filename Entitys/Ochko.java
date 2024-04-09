package Simulation.Entitys;

import Simulation.*;
import Simulation.Map.Map;

import java.util.HashSet;
import java.util.Set;

public class Ochko extends Entity {
    public Ochko(Form form, Coordinates coordinates) {
        super(form, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getEntityMove() {
        Set<CoordinatesShift> result = new HashSet<>();

        for (int vertShift = -1; vertShift <= 1; vertShift++) {
            for (int horiShift = -1; horiShift <= 1; horiShift++) {
                if ((vertShift == 0) && (horiShift == 0)){
                    continue;
                }

                result.add(new CoordinatesShift(vertShift,horiShift));
            }
        }

        return result;
    }


    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, Map map) {
        boolean result = super.isSquareAvailableForMove(coordinates, map);

        if (result){
            return !map.isSquareAttackedByForm(coordinates,form.opposite());
        }

        return false;

    }
}
