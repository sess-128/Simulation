package Silmulation;

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

    private boolean isSquareAvailableForMove(Coordinates coordinates, Map map) {
        return map.isSquareEmpty(coordinates) || map.getEntity(coordinates).form != form;
    }
    protected abstract Set<CoordinatesShift> getEntityMove();

}
