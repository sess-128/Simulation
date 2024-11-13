package CloneSim.Actions.InitActions;

import CloneSim.Actions.Action;
import CloneSim.Entities.Entity;
import CloneSim.Factories.EntityFactory;
import CloneSim.Entities.EntityType;
import CloneSim.Board.Board;

import java.util.Collection;

public class FillMap extends Action {
    public final static int GRASS_COUNT = 4;
    private final static int ROCK_COUNT = 4;
    private final static int TREE_COUNT = 3;
    public final static int HERBIVORE_COUNT = 2;
    private final static int PREDATOR_COUNT = 4;
    private final EntityFactory factory = new EntityFactory();

    public FillMap(Board board) {
        super(board);
    }

    @Override
    public void interact() {
        for (EntityType value : EntityType.values()) {
            int count = getEntityCountToPlace(value);
            Collection<Entity> necessaryEntities = factory.makeMoreEntities(value, count);

            fill(necessaryEntities);
        }
    }
    private int getEntityCountToPlace(EntityType type) {
        return switch (type) {
            case GRASS -> GRASS_COUNT;
            case ROCK -> ROCK_COUNT;
            case TREE -> TREE_COUNT;
            case HERBIVORE -> HERBIVORE_COUNT;
            case PREDATOR -> PREDATOR_COUNT;
        };
    }


}
