package CloneSim.Factories;

import CloneSim.Factories.Entity;
import CloneSim.Factories.EntityType;

public abstract class Creature extends Entity {
    protected int health;
    protected int speed;

    public Creature(EntityType type, int health, int speed) {
        super(type);
        this.health = health;
        this.speed = speed;
    }

    protected abstract void makeMove();
}
