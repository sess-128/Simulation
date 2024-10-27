package simulation.Entitys;

import simulation.Coordinates;

public abstract class Entity {
    public final Type type;

    public Entity(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
