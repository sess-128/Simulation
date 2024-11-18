package CloneSim.Actions.TurnActions;

import CloneSim.Actions.Action;
import CloneSim.Board.Board;
import CloneSim.Entities.Grass;
import CloneSim.Entities.Herbivore;
import CloneSim.Entities.Entity;
import CloneSim.Factories.EntityFactory;
import CloneSim.Entities.EntityType;


import java.util.Collection;

import static CloneSim.Actions.InitActions.FillMap.GRASS_COUNT;
import static CloneSim.Actions.InitActions.FillMap.HERBIVORE_COUNT;

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
            System.out.println("Creating " + (GRASS_COUNT - currentGrass) + " Grass");
            System.out.println("Creating " + (HERBIVORE_COUNT - currentHerbivore) + " Herbivore");
        }
    }

    private int[] getEntityCount(){


        int countGrass = 0;
        int countHerbivore = 0;

        for (Entity entity : board.getEntities()) {
            if (entity instanceof Grass){
                countGrass++;
            }
            if (entity instanceof Herbivore){
                countHerbivore++;
            }
        }
        return new int[]{countGrass,countHerbivore};
    }
}
