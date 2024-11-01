package simulation;

import simulation.Map.Map;
import simulation.Map.MapRender;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        MapRender render = new MapRender();
        Overseer overseer = new Overseer(map);

        map.setCheckPos();
        render.show(map);


    }
}
