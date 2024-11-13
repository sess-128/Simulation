package CloneSim.Board;

import CloneSim.Coordinates;
import CloneSim.Factories.Entity;

public class MapRender {
    public static final String EMPTY = "\uD83D\uDFEB";
    public static final String HERBIVORE_PICTURE = "\uD83D\uDE07";
    public static final String PREDATOR_PICTURE = "\uD83D\uDC7F";
    public static final String GRASS_PICTURE = "\uD83C\uDF3C";
    public static final String ROCK_PICTURE = "\uD83C\uDF11";
    public static final String TREE_PICTURE = "\uD83C\uDF33";

    public void show(Board board) {
        int ROWS = board.getHeight();
        int COLUMNS = board.getWidth();

        for (int row = ROWS; row >= 0; row--) {
            StringBuilder line = new StringBuilder();
            for (int col = 0; col < COLUMNS; col++) {
                Coordinates coordinates = new Coordinates(row, col);

                if (board.isEmptyCoordinates(coordinates)) {
                    line.append(colorizeEmptyCoordinates());
                } else {
                    line.append(colorizeEntity(board.getEntity(coordinates)));
                }

            }
            System.out.println(line);
        }
    }

    private String colorizeEntity(Entity entity) {
        String result = "";
        switch (entity.getType()) {
            case TREE -> result += TREE_PICTURE;
            case ROCK -> result += ROCK_PICTURE;
            case GRASS -> result += GRASS_PICTURE;
            case HERBIVORE -> result += HERBIVORE_PICTURE;
            case PREDATOR -> result += PREDATOR_PICTURE;
            default -> result += EMPTY;
        }

        return result;
    }

    private String colorizeEmptyCoordinates() {
        String result = "";
        result += EMPTY;

        return result;
    }
}
