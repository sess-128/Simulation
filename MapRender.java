package simulation;

import simulation.Entitys.Entity;

public class MapRender {

    public static final String EMPTY = "\uD83D\uDFEB";
    public static final String HERBIVORE_PICTURE = "\uD83D\uDE07";
    public static final String PREDATOR_PICTURE = "\uD83D\uDC7F";
    public static final String GRASS_PICTURE = "\uD83C\uDF3C";
    public static final String ROCK_PICTURE = "\uD83C\uDF11";
    public static final String TREE_PICTURE = "\uD83C\uDF33";

    public static final int ROWS = 10, COLUMNS = 1d0;

    public void show(Map map) {
        for (int row = ROWS; row > 0; row--) {
            String line = "";
            for (int col = 0; col < COLUMNS; col++) {
                Coordinates coordinates = new Coordinates(row, col);

                if (map.isEmptyCoordinate(coordinates)) {
                    line += colorizeEmptyCoordinates();
                } else {
                    line += colorizeEntity(map.getEntityByCoordinates(coordinates));
                }

            }
            System.out.println(line);
        }
    }

    private String colorizeEntity(Entity entity) {
        String result = "";
        switch (entity.getType()) {
            case Tree -> result += TREE_PICTURE;
            case Rock -> result += ROCK_PICTURE;
            case Grass -> result += GRASS_PICTURE;
            case Herbivore -> result += HERBIVORE_PICTURE;
            case Predator -> result += PREDATOR_PICTURE;
        }

        return result;
    }

    private String colorizeEmptyCoordinates() {
        String result = "";
        result += EMPTY;

        return result;
    }
}

