package CloneSim.Actions.InitActions;

import CloneSim.Actions.Action;
import CloneSim.Board.Board;
import CloneSim.Entities.Entity;
import CloneSim.Entities.EntityType;
import CloneSim.Factories.EntityFactory;

import java.util.ArrayList;
import java.util.Collection;

public class FillMap extends Action {
    public final static int GRASS_COUNT = 5;
    public final static int HERBIVORE_COUNT = 5;
    private final static int ROCK_COUNT = 10;
    private final static int TREE_COUNT = 10;
    private final static int PREDATOR_COUNT = 8;
    private final EntityFactory factory = new EntityFactory();

    public FillMap(Board board) {
        super(board);
    }

    @Override
    public void interact() {
        Collection<Entity> necessaryEntities = new ArrayList<>();

        for (EntityType value : EntityType.values()) {
            int count = getEntityCountToPlace(value);
            necessaryEntities.addAll(factory.makeMoreEntities(value, count));
        }
        fill(necessaryEntities);

    }

    private int getEntityCountToPlace(EntityType type) {
        return switch (type) {
            case GRASS -> GRASS_COUNT;
            case ROCK -> ROCK_COUNT;
            case TREE -> TREE_COUNT;
            case HERBIVORE -> HERBIVORE_COUNT;
            case PREDATOR -> PREDATOR_COUNT;
            case GROUND -> 0;
        };
    }


}
