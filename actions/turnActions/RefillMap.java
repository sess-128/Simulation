package cloneSim.actions.turnActions;

import cloneSim.actions.Action;
import cloneSim.board.Board;
import cloneSim.entities.Entity;
import cloneSim.entities.EntityType;
import cloneSim.entities.Grass;
import cloneSim.entities.Herbivore;
import cloneSim.factories.EntityFactory;

import java.util.Collection;

import static cloneSim.actions.initActions.FillMap.GRASS_COUNT;
import static cloneSim.actions.initActions.FillMap.HERBIVORE_COUNT;

public class RefillMap extends Action {

    public RefillMap(Board board) {
        super(board);
    }

    @Override
    public void interact() {
        EntityFactory factory = new EntityFactory();
        int[] refillable = getEntityCount();
        int currentGrass = refillable[0];
        int currentHerbivore = refillable[1];


        Collection<Entity> entitiesToRefill;

        entitiesToRefill = factory.makeMoreEntities(EntityType.GRASS, GRASS_COUNT - currentGrass);
        entitiesToRefill.addAll(factory.makeMoreEntities(EntityType.HERBIVORE, HERBIVORE_COUNT - currentHerbivore));

        if (currentGrass <= GRASS_COUNT || currentHerbivore <= HERBIVORE_COUNT) {
            fill(entitiesToRefill);
        }
    }

    private int[] getEntityCount() {


        int countGrass = 0;
        int countHerbivore = 0;

        for (Entity entity : board.getAllEntities()) {
            if (entity instanceof Grass) {
                countGrass++;
            }
            if (entity instanceof Herbivore) {
                countHerbivore++;
            }
        }
        return new int[]{countGrass, countHerbivore};
    }
}
