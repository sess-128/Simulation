package CloneSim.Entities;

import CloneSim.Factories.Creature;
import CloneSim.Factories.EntityType;

public class Herbivore extends Creature {
    private final EntityType target = EntityType.GRASS;
    public Herbivore(int health, int speed) {
        super(EntityType.HERBIVORE, health, speed);
    }

    @Override
    protected void makeMove() {

    }
}
