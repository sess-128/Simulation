package simulation;

import simulation.Entitys.Entity;
import simulation.Entitys.Predator;
import simulation.Entitys.Type;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        MapRender render = new MapRender();

        map.setCheckPos();
        render.show(map);
    }
}
