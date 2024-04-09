package Simulation;

public enum Form {
    TREE, GRAB, ROCK, HERBIVORE, PREDATOR, ASSASIN, OCHKO;

    public Form opposite() {
        return this == PREDATOR ? HERBIVORE : PREDATOR;
    }
}
