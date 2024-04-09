package Simulation.Entitys;

import Simulation.*;
import Simulation.Map.Map;

import java.util.HashSet;
import java.util.Set;

public class Assasin extends Entity {
    public Assasin(Form form, Coordinates coordinates) {
        super(form, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getEntityMove() {
        Set<CoordinatesShift> result = new HashSet<>();

        result.add(new CoordinatesShift(-1,0));
        result.add(new CoordinatesShift(-1,-1));
        result.add(new CoordinatesShift(-1,1));

        return result;
    }

    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, Map map) {
        if (this.coordinates.hori == coordinates.hori){
            return map.isSquareEmpty(coordinates);
        } else {
            if (map.isSquareEmpty(coordinates)){
                return false;
            } else {
                return map.getEntity(coordinates).form != form;
            }
        }
    }
}
