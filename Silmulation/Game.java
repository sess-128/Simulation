package Silmulation;

import java.util.Set;

public class Game {

    private final Map map;

    private MapConsoleRenderer renderer = new MapConsoleRenderer();

    public Game(Map map) {
        this.map = map;
    }

    public void gameLoop(){

        boolean isPredatorToMove = true;
        while(true){
            renderer.render(map);

            if (isPredatorToMove){
                System.out.println("Predator move");
            } else {
                System.out.println("Herbivore move");
            }

            Coordinates sourceCoordinates = InputCoordinates.inputEntityCoordinatesForForm(
                    isPredatorToMove ? Form.PREDATOR : Form.HERBIVORE, map);

            Entity entity = map.getEntity(sourceCoordinates);
            Set<Coordinates> availableMoveSquare = entity.getAvailableMoveSquare(map);;
            Coordinates targetCoordinates = InputCoordinates.inputAvailableSquare(availableMoveSquare);

            map.moveEntity(sourceCoordinates, targetCoordinates);

            isPredatorToMove =! isPredatorToMove;

        }
    }
}
