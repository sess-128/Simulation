package Simulation.Entitys;

import Simulation.CoordinatesShift;
import Simulation.Form;
import Simulation.Coordinates;
import java.util.Set;

public class Predator extends LongRangeEntity implements IPredator {
    public Predator(Form form, Coordinates coordinates) {
        super(form, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getEntityMove() {
        return getPredatorMove();
    }
}
