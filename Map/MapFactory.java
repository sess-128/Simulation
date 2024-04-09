package Simulation.Map;
import Simulation.Coordinates;
import Simulation.EntityFactory;

public class MapFactory {

    private final EntityFactory entityFactory = new EntityFactory();

    public Map fromFEN(String fen){


        Map map = new Map(fen);


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

    public Map copy(Map source){
        Map clone = fromFEN(source.startingFen);

        for (Move move : source.moves) {
            clone.makeMove(move);
        }

        return clone;
    }
}
