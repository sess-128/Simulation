package cloneSim.entities;

public abstract class Entity {
    protected final EntityType type;
    public Entity(EntityType type) {
        this.type = type;
    }
    public EntityType getType() {
        return type;
    }
}
