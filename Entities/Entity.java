package CloneSim.Entities;

public abstract class Entity {
    protected EntityType type;

    public Entity(EntityType type) {
        this.type = type;
    }

    public EntityType getType() {
        return type;
    }
}
