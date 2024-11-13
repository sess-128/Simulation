package CloneSim.Entities;

import CloneSim.Factories.Creature;
import CloneSim.Factories.EntityType;

public class Predator extends Creature {
    private final EntityType target = EntityType.HERBIVORE;
    private final int power;
    public Predator(int health, int speed, int power) {
        super(EntityType.PREDATOR, health, speed);
        this.power = power;
    }

    @Override
    protected void makeMove() {

    }
}
