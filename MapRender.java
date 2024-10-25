package simulation;

import simulation.Entitys.Entity;

public class MapRender {

    public static final int ROWS = 15, COLUMNS = 15;

    public void show(Map map) {
        for (int row = 0; row < ROWS; row++) {
            System.out.print("|");
            for (int col = 0; col < COLUMNS; col++) {
                Coordinates coordinates = new Coordinates(row,col);

                Entity exist = map.getEntityByCoordinates(coordinates);
                System.out.print((exist != null ? exist : "_") + "|");
            }
            System.out.println();
        }
    }
}
