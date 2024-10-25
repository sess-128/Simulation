package simulation;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        MapRender render = new MapRender();

        map.placeEntity(new Coordinates(1,2), Entity.Grass);
        map.placeEntity(new Coordinates(2,2), Entity.Grass);
        map.placeEntity(new Coordinates(5,2), Entity.Grass);
        map.placeEntity(new Coordinates(8,2), Entity.Grass);

        render.show(map);
    }
}
