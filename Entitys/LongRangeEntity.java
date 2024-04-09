package Simulation.Entitys;

import Simulation.*;
import Simulation.Map.Map;
import Simulation.Map.MapUtils;

import java.util.List;

public abstract class LongRangeEntity extends Entity {
    public LongRangeEntity(Form form, Coordinates coordinates) {
        super(form, coordinates);
    }
    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, Map map) {
        boolean result = super.isSquareAvailableForMove(coordinates, map);

        if (result) {
           return isSquareAvailableForAttack(coordinates, map);
        } else {
            return false;
        }
    }

    @Override
    protected boolean isSquareAvailableForAttack(Coordinates Coordinates, Map map) {
        List<Coordinates> coordinatesBetween;
        if (this.coordinates.vert == coordinates.vert) {
            coordinatesBetween = MapUtils.getVerticalCoordinatesBetween(this.coordinates, coordinates);
        } else if (this.coordinates.hori.equals(coordinates.hori)) {
            coordinatesBetween = MapUtils.getHorizontalCoordinatesBetween(this.coordinates, coordinates);
        } else {
            coordinatesBetween = MapUtils.getDiagonalCoordinatesBetween(this.coordinates, coordinates);
        }

        for (Coordinates c : coordinatesBetween) {
            if (!map.isSquareEmpty(c)) {
                return false;
            }
        }
        return true;
    }
}

// extends LongRangeEntity, для всех криво и прямо  ходящих