package CloneSim.Board;

import CloneSim.Actions.InitActions.FillMap;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        MapRender render = new MapRender();

        FillMap init = new FillMap(board);

        board = init.initMap();




        render.show(board);



    }
}
