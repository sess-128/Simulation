package Simulation.Entitys;

import Simulation.*;

import java.util.Set;

public class Herbivore extends LongRangeEntity implements IHerbivore{
    public Herbivore(Form form, Coordinates coordinates) {
        super(form, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getEntityMove() {
        return getHerbivoreMove();
    }
}

//        // left to right
//        for (int i =-7; i < 7; i++) {
//            if (i == 0) continue;
//            result.add(new CoordinatesShift(0,i));
//        }
//        // bot to top
//        for (int i =-7; i < 7; i++) {
//            if (i == 0) continue;
//            result.add(new CoordinatesShift(i,0));
//        }

    

//    @Override
//    protected boolean isSquareAvailableForMove(Coordinates coordinates, Map map) {
//        boolean result = super.isSquareAvailableForMove(coordinates, map);
//
//        if (result) {
//            List<Coordinates> coordinatesBetween = MapUtils.getDiagonalCoordinatesBetween(this.coordinates, coordinates);
//
//            for (Coordinates c: coordinatesBetween) {
//                if (!map.isSquareEmpty(c)){
//                    return false;
//                }
//            } return true;
//        } else {
//            return false;
//        }


//        // для тех, кто ходит прямо
//        if (result) {
//            List<Coordinates> coordinatesBetween;
//            if (this.coordinates.vert == coordinates.vert){
//                coordinatesBetween = MapUtils.getVerticalCoordinatesBetween(this.coordinates,coordinates);
//            } else {
//                coordinatesBetween = MapUtils.getHorizontalCoordinatesBetween(this.coordinates,coordinates);
//            }
//
//            for (Coordinates c: coordinatesBetween) {
//                if (!map.isSquareEmpty(c)){
//                    return false;
//                }
//            } return true;
//        } else {
//            return false;
//        }



