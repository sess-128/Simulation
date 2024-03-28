package Silmulation;

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



    public void render(Map map){
        for (int vert = VERTICAL_COUNT; vert >= 1; vert--) {
            String line = "";
            for (int hori = 1; hori <= HORIZONTAL_COUNT; hori++){
                Coordinates coordinates = new Coordinates(vert,hori);

                if (map.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmpty(new Coordinates(vert, hori));
                } else {
                    line += getEntitySprite(map.getEntity(coordinates));
                }
            }
            line += ANSII_RESET;
            System.out.println(line);

        }
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
        }
        return "";
    }

    private String getSpriteForEmpty (Coordinates coordinates){ // 🔘
        return colorizeSprite(
                " \uD83D\uDD18 ",Form.GRAB,isSquareGrey(coordinates), true);
    }

    public static boolean isSquareGrey (Coordinates coordinates){
        return (coordinates.vert + coordinates.hori) % 2 == 0;
    }

    private String getEntitySprite (Entity entity){
        return colorizeSprite(
                " "+selectUnicodeSpriteForEntity(entity)+" ",entity.form, isSquareGrey(entity.coordinates), true);
    }

    private String colorizeSprite (String sprite,Form entityForm, boolean isSquareGrey, boolean isHighlighted){
        String result = sprite;

        if (isHighlighted){
            result += ANSI_HIGHLITED;
        }
        else if (isSquareGrey){
            result = ANSII_BG_GREY + result;
        } else {
            result = ANSII_BG_NOT_GREY + result;
        }

//        switch (entityForm){
//            case TREE -> result = ANSII_TREE + result;
//            case GRAB -> result = ANSII_GRAB + result;
//            case ROCK -> result = ANSII_ROCK + result;
//            case HERBIVORE -> result = ANSII_HERBIVORE + result;
//            case PREDATOR -> result = ANSII_PREDATOR + result;
//        }


        return result;
    }


}
