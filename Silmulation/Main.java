package Silmulation;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        map.setupDefaultEntitysPosition();

        MapConsoleRenderer renderer = new MapConsoleRenderer();
        renderer.render(map);
    }
}
