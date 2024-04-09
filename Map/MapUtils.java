package Simulation.Map;

import Simulation.Coordinates;

import java.util.ArrayList;
import java.util.List;

public class MapUtils {
    public static List<Coordinates> getDiagonalCoordinatesBetween(Coordinates source, Coordinates target){
        List<Coordinates> result = new ArrayList<>();

        int vertShift = source.vert < target.vert ? 1 : -1;
        int horiShift = source.hori < target.hori ? 1 : -1;

        for (
                int vertIndex = source.vert + vertShift,
                horiIndex = source.hori + horiShift;

                vertIndex != target.vert && horiIndex != target.hori;

                vertIndex += vertShift, horiIndex += horiShift
                ) {
            result.add(new Coordinates(vertIndex,horiIndex));
        }

        return result;
    }
    public static List<Coordinates> getHorizontalCoordinatesBetween(Coordinates source, Coordinates target){
        List<Coordinates> result = new ArrayList<>();

        int vertShift = source.vert < target.vert ? 1 : -1;

        for (int vertIndex = source.vert + vertShift;vertIndex != target.vert; vertIndex += vertShift) {
            result.add(new Coordinates(vertIndex,source.hori));
        }

        return result;
    }

    public static List<Coordinates> getVerticalCoordinatesBetween(Coordinates source, Coordinates target){
        List<Coordinates> result = new ArrayList<>();

        int horiShift = source.hori < target.hori ? 1 : -1;

        for (int horiIndex = source.hori + horiShift; horiIndex != target.hori; horiIndex += horiShift) {
            result.add(new Coordinates(source.vert, horiIndex));
        }

        return result;
    }

//    public static void main(String[] args) {
//        List<Coordinates> list = getVerticalCoordinatesBetween(new Coordinates(1, 1), new Coordinates(7, 1));
//        List<Coordinates> list2 = getHorizontalCoordinatesBetween(new Coordinates(1, 1), new Coordinates(1, 3));
//
//        System.out.println("list = " + list);
//        System.out.println("list2 = " + list2);
//    }
}
