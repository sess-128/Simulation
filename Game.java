package Simulation;

import Simulation.Map.Map;
import Simulation.Map.Move;

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

            Move move = InputCoordinates.inputMove(map, isPredatorToMove ? Form.PREDATOR : Form.HERBIVORE, renderer);

            map.makeMove(move);

            isPredatorToMove =! isPredatorToMove;

        }
    }
}
