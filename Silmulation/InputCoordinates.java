package Silmulation;

import java.util.Scanner;
import java.util.Set;


public class InputCoordinates {
    private final static Scanner scanner = new Scanner(System.in);

    public static Coordinates input(){
        while (true){

            System.out.println("Please, enter coordinates (ex 11)");

            String line = scanner.nextLine();

            if (line.length() != 2){
                System.out.println("Invalid format");
                continue;
            }

            char vertChar = line.charAt(0);
            char horiChar = line.charAt(1);

            if ((!Character.isDigit(vertChar)) || (!Character.isDigit(horiChar))){
                System.out.println("Invalid format");
                continue;
            }

            int vert = Character.getNumericValue(vertChar);
            int hori = Character.getNumericValue(horiChar);
            if ((hori < 1 || hori > MapConsoleRenderer.HORIZONTAL_COUNT) || (vert < 1 || vert > MapConsoleRenderer.VERTICAL_COUNT)){
                System.out.println("Invalid format");
                continue;
            }

            return new Coordinates(vert,hori);
        }
    }

    public static Coordinates inputEntityCoordinatesForForm(Form form, Map map){
        while (true){
            System.out.println("Enter coordinates for a entity to move");
            Coordinates coordinates = input();

            if (map.isSquareEmpty(coordinates)){
                System.out.println("Empty square");
                continue;
            }

            Entity entity = map.getEntity(coordinates);
            if (entity.form != form){
                System.out.println("Wrong form");
                continue;
            }

            Set<Coordinates> availableMoveSquare = entity.getAvailableMoveSquare(map);
            if (availableMoveSquare.size() == 0) {
                System.out.println("Blocked entity");
                continue;
            }

            return coordinates;

        }
    }

    public static Coordinates inputAvailableSquare (Set<Coordinates> coordinates){
        while (true) {

            System.out.println("Please, enter your move for selected entity");
            Coordinates input = input();

            if (!coordinates.contains(input)){
                System.out.println("Non available square");
                continue;
            }

            return input;
        }
    }

    public static void main(String[] args) {
        Map map = new Map();
        map.setupDefaultEntitysPosition();

        Coordinates coordinates = inputEntityCoordinatesForForm(Form.PREDATOR, map);
        System.out.println("coordinates = " + coordinates);
    }
}
