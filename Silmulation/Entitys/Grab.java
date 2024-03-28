package Silmulation.Entitys;

import Silmulation.CoordinatesShift;
import Silmulation.Form;
import Silmulation.Coordinates;
import Silmulation.Entity;

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
