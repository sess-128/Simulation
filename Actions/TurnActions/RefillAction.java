package CloneSim.Actions.TurnActions;

import CloneSim.Actions.Action;
import CloneSim.Board.Board;
import CloneSim.Entities.Grass;
import CloneSim.Entities.Herbivore;
import CloneSim.Entities.Entity;
import CloneSim.Factories.EntityFactory;
import CloneSim.Entities.EntityType;

import java.util.ArrayList;
import java.util.Collection;

import static CloneSim.Actions.InitActions.FillMap.GRASS_COUNT;
import static CloneSim.Actions.InitActions.FillMap.HERBIVORE_COUNT;

public class RefillAction extends Action {

    public RefillAction(Board board) {
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

        if (GRASS_COUNT - currentGrass > 0 || HERBIVORE_COUNT - currentHerbivore > 0) {
            fill(entitiesToRefill);
        }
    }

    private int[] getEntityCount(){
        Collection<Entity> entities = board.getEntities();

        int countGrass = 0;
        int countHerbivore = 0;

        for (Entity entity : entities) {
            if (entity instanceof Herbivore){
                countGrass++;
            }
            if (entity instanceof Grass){
                countHerbivore++;
            }
        }
        return new int[]{countGrass,countHerbivore};
    }
}
