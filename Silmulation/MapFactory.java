package Silmulation;

import Silmulation.Entitys.Predator;

public class MapFactory {
    public Map fromFEN(String fen){
        // rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1

        EntityFactory entityFactory = new EntityFactory();

        Map map = new Map();


        String[] parts = fen.split(" ");
        String entityPositions = parts[0];

        String[] fenRows = entityPositions.split("/");

        for (int i = 0; i < fenRows.length; i++) {
            String row = fenRows[i];
            int vert = 8 - i;


            int horiIndex = 1;
            for (int j = 0; j < row.length(); j++) {
                char fenChar = row.charAt(j);

                if (Character.isDigit(fenChar)){
                    horiIndex += Character.getNumericValue(fenChar);
                } else {
                    Coordinates coordinates = new Coordinates(vert, horiIndex);

                    map.setEntitys(coordinates, entityFactory.fromFenChar(fenChar, coordinates));
                    horiIndex++;
                }
                
            }
        }
        return map;
    }

    public static void main(String[] args) {

    }
}
