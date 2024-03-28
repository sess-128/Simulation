package Silmulation;

import Silmulation.Entitys.*;

public class EntityFactory {
    Entity fromFenChar(char fenChar, Coordinates coordinates){
        switch (fenChar){
            case 'g':
                return new Grab(Form.GRAB, coordinates);
            case 'h':
                return new Herbivore(Form.HERBIVORE, coordinates);
            case 'p':
                return new Predator(Form.PREDATOR, coordinates);
            case 'r':
                return new Rock(Form.ROCK, coordinates);
            case 't':
                return new Tree(Form.TREE, coordinates);

            default:
                throw new RuntimeException("Unknown FEN char");
        }
    }
}
