package Silmulation;

public class Main {
    public static void main(String[] args) {
//        Map map = new Map();
//        map.setupDefaultEntitysPosition();

        Map map = (new MapFactory()).fromFEN("1g1p3g/t1rg2h1/2r2rr1/2p1h1g1/6p1/1g1rhr2/1p2r2h/g3t3");

        MapConsoleRenderer renderer = new MapConsoleRenderer();
        renderer.render(map);
//
//        Entity entity = map.getEntity(new Coordinates(10,10));
//        Set<Coordinates> availableMoveSquare = entity.getAvailableMoveSquare(map);
//
//        int a = 123;
//
//        Game game = new Game(map);
//        game.gameLoop();

    }
}
