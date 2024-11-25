package cloneSim.factories;

import cloneSim.entities.*;

import java.util.ArrayList;
import java.util.Collection;

public class EntityFactory {
    public Entity makeEntity(EntityType type) {
        Entity entity = null;

        switch (type) {
            case GRASS -> entity = new Grass();
            case ROCK -> entity = new Rock();
            case TREE -> entity = new Tree();
            case HERBIVORE -> entity = new Herbivore(14, 3);
            case PREDATOR -> entity = new Predator(10, 2, 2);
        }

        return entity;
    }

    public Collection<Entity> makeMoreEntities(EntityType type, int count) {

        Collection<Entity> entities = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            entities.add(makeEntity(type));
        }
        return entities;
    }
}
