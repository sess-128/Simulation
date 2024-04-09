package Simulation;

import Simulation.Map.Map;

import java.util.HashSet;
import java.util.Set;

public abstract class Entity {
    public final Form form;
    public Coordinates coordinates;

    public Entity(Form form, Coordinates coordinates) {
        this.form = form;
        this.coordinates = coordinates;
    }

    public Set<Coordinates> getAvailableMoveSquare(Map map) {

        Set<Coordinates> result = new HashSet<>();

        for (CoordinatesShift shift : getEntityMove()){
            if (coordinates.canShift(shift)){
                Coordinates newCoordinates = coordinates.shift(shift);

                if (isSquareAvailableForMove(newCoordinates, map)){
                    result.add(newCoordinates);
                }
            }
        }
        return result;
    }

    protected boolean isSquareAvailableForMove(Coordinates coordinates, Map map) {
        return map.isSquareEmpty(coordinates) || map.getEntity(coordinates).form != form;
    }
    protected abstract Set<CoordinatesShift> getEntityMove();
    protected Set<CoordinatesShift> getEntityAttacks(){
        return getEntityMove();
    }

    public Set<Coordinates> getAttackedSquares(Map map) {
        Set<CoordinatesShift> entityAttacks = getEntityAttacks();
        Set<Coordinates> result = new HashSet<>();

        for (CoordinatesShift entityAttack : entityAttacks) {
            if (coordinates.canShift(entityAttack)){
                Coordinates shiftedCoordinates = coordinates.shift(entityAttack);

                if (isSquareAvailableForAttack(shiftedCoordinates, map)){
                    result.add(shiftedCoordinates);
                }
            }
        }

        return result;
    }

    protected boolean isSquareAvailableForAttack(Coordinates Coordinates, Map map) {
        return true;
    }
}
