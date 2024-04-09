package Simulation;

import Simulation.Map.Map;

import java.util.Set;

import static java.util.Collections.emptySet;

public class MapConsoleRenderer {
    public static final int VERTICAL_COUNT = 8;
    public static final int HORIZONTAL_COUNT = 8;

    public static final String ANSII_PREDATOR = "\033[0;31m";
    public static final String ANSII_HERBIVORE = "\033[0;32m";
    public static final String ANSII_TREE = "\033[0;92m";
    public static final String ANSII_GRAB = "\033[0;96m";
    public static final String ANSII_ROCK = "\033[0;90m";
    public static final String ANSII_BG_GREY = "";
    public static final String ANSII_BG_NOT_GREY = "";
    public static final String ANSI_HIGHLITED = "\033[0;41m";
    public static final String ANSII_RESET = "\033[0m";  // Text Reset



    public void render(Map map, Entity entityToMove){
        Set<Coordinates> availableMoveSquare = emptySet();
        if (entityToMove != null){
            availableMoveSquare = entityToMove.getAvailableMoveSquare(map);
        }

        for (int vert = VERTICAL_COUNT; vert >= 1; vert--) {
            String line = "";
            for (int hori = 1; hori <= HORIZONTAL_COUNT; hori++){
                Coordinates coordinates = new Coordinates(vert,hori);

                boolean isHighlight = availableMoveSquare.contains(coordinates);

                if (map.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmpty(coordinates, isHighlight);
                } else {
                    line += getEntitySprite(map.getEntity(coordinates), isHighlight);
                }
            }
            line += ANSII_RESET;
            System.out.println(line);

        }
    }
    public void render(Map map){
        render(map, null);
    }

    public String selectUnicodeSpriteForEntity (Entity entity){
        switch (entity.getClass().getSimpleName()){
            case "Tree":
                return "\uD83C\uDF33";
            case "Grab":
                return "\uD83C\uDF31";
            case "Rock":
                return "⬛";
            case "Predator":
                return "\uD83D\uDC05";
            case "Herbivore":
                return "\uD83D\uDC11";
            case "Assasin":
                return "\uD83D\uDE08";
            case "Ochko":
                return "\uD83D\uDE49";
        }
        return "";
    }

    private String getSpriteForEmpty (Coordinates coordinates, boolean isHighlight){ // 🔘
        return colorizeSprite(
                " \uD83D\uDD18 ",Form.GRAB,isSquareGrey(coordinates), isHighlight);
    }

    public static boolean isSquareGrey (Coordinates coordinates){
        return (coordinates.vert + coordinates.hori) % 2 == 0;
    }

    private String getEntitySprite (Entity entity, boolean isHighlight){
        return colorizeSprite(
                " "+selectUnicodeSpriteForEntity(entity)+" ",entity.form, isSquareGrey(entity.coordinates), isHighlight);
    }

    private String colorizeSprite (String sprite,Form entityForm, boolean isSquareGrey, boolean isHighlight){
        String result = sprite;

        if (isHighlight){
            result = ANSI_HIGHLITED + result;
        }
        else if (isSquareGrey){
            result = ANSII_BG_GREY + result;
        } else {
            result = ANSII_BG_NOT_GREY + result;
        }

        switch (entityForm){
            case TREE -> result = ANSII_TREE + result;
            case GRAB -> result = ANSII_GRAB + result;
            case ROCK -> result = ANSII_ROCK + result;
            case HERBIVORE -> result = ANSII_HERBIVORE + result;
            case PREDATOR -> result = ANSII_PREDATOR + result;
        }


        return result;
    }


}
