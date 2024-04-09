package Simulation.Entitys;

import Simulation.CoordinatesShift;
import Simulation.Form;
import Simulation.Coordinates;
import Simulation.Entity;

import java.util.Set;

public class Grab extends Entity {
    public Grab(Form form, Coordinates coordinates) {
        super(form, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getEntityMove() {
        return null;
    }
}
