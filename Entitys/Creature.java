package simulation.Entitys;

import simulation.Coordinates;
import simulation.CoordinatesShift;

import java.util.Set;

public abstract class Creature extends Entity{
    private int speed;
    private int health;

    public Creature(Type type) {
        super(type);
    }

    public abstract void makeMove();
    public abstract Set<CoordinatesShift> moves ();


}
