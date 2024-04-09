package Simulation.Entitys;

import Simulation.CoordinatesShift;
import Simulation.Form;
import Simulation.Coordinates;
import Simulation.Entity;

import java.util.Set;

public class Tree extends Entity {
    public Tree(Form form, Coordinates coordinates) {
        super(form, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getEntityMove() {
        return null;
    }
}
