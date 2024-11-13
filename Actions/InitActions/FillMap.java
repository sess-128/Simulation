package CloneSim.Actions.InitActions;

import CloneSim.Actions.Action;
import CloneSim.Coordinates;
import CloneSim.Entities.Grass;
import CloneSim.Factories.Entity;
import CloneSim.Factories.EntityFactory;
import CloneSim.Factories.EntityType;
import CloneSim.Board.Board;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class FillMap extends Action {
    private final static int GRASS_COUNT = 9;
    private final static int ROCK_COUNT = 9;
    private final static int TREE_COUNT = 9;
    private final static int HERBIVORE_COUNT = 5;
    private final static int PREDATOR_COUNT = 3;

    private final EntityFactory factory = new EntityFactory();

    public FillMap(Board board) {
        super(board);
    }

    @Override
    protected void interact() {

    }

    public Board initMap() {

        Random random = new Random();
        int totalEntities = GRASS_COUNT + TREE_COUNT + ROCK_COUNT + PREDATOR_COUNT + HERBIVORE_COUNT;

        for (int i = 0; i < totalEntities; i++) {
            int randomRow = random.nextInt(board.getHeight());
            int randomColumn = random.nextInt(board.getWidth());
            Coordinates randomCoordinates = new Coordinates(randomRow,randomColumn);


            Collection<Entity> necessaryEntities = new ArrayList<>();

            for (EntityType entityType : EntityType.values()) {
                int count = getEntityCount(entityType);

                for (int j = 0; j < count; j++) {
                    necessaryEntities.add(factory.makeEntity(entityType));
                }

                for (Entity necessaryEntity : necessaryEntities) {
                    board.add(randomCoordinates, necessaryEntity);
                }
            }


        }

        return board;
    }

    private void makeGrass(int count) {
        factory.makeMoreEntities(EntityType.GRASS, GRASS_COUNT);
    }

    private int getEntityCount(EntityType type) {
        return switch (type) {
            case GRASS -> GRASS_COUNT;
            case ROCK -> ROCK_COUNT;
            case TREE -> TREE_COUNT;
            case HERBIVORE -> HERBIVORE_COUNT;
            case PREDATOR -> PREDATOR_COUNT;
        };
    }


}
