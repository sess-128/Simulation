package CloneSim;

import CloneSim.Actions.InitActions.FillMap;
import CloneSim.Actions.TurnActions.MoveCreatures;
import CloneSim.Actions.TurnActions.RefillMap;
import CloneSim.Board.Board;
import CloneSim.Board.BoardRender;

public class Simulation {
    public static int MOVE_COUNTER = 0;
    private final Board board;
    private final BoardRender boardRender;
    private final FillMap fillMap;
    private final MoveCreatures moveCreatures;
    private final RefillMap refillMap;

    private volatile boolean running;
    private Thread simulationThread;

    public Simulation() {
        this.board = new Board();
        this.boardRender = new BoardRender();
        this.fillMap = new FillMap(board);
        this.moveCreatures = new MoveCreatures(board);
        this.refillMap = new RefillMap(board);
        this.running = false;
        fillMap.interact();
    }

    public void nextTurn(){
        System.out.println("Делаю следующий ход");
        boardRender.show(board);
        moveCreatures.interact();
        refillMap.interact();
        showCountMoves();
    }
    public void startSimulation(){
        if (running){
            System.out.println("Симуляция уже запущена");
            return;
        }

        running = true;

        simulationThread = new Thread(() -> {
            while (running){
                nextTurn();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        simulationThread.start();
    }
    public void pauseSimulation(){
        if (!running){
            return;
        }
        System.out.println("Симуляция на паузе");
        running = false;

        try {
            simulationThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void resumeSimulation(){
        running = true;
        System.out.println("Симуляция продолжается");
        simulationThread = new Thread(() -> {
            while (running){
                nextTurn();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        simulationThread.start();
    }

    private void showCountMoves(){
        MOVE_COUNTER++;
        System.out.println("Сделано итераций: " + MOVE_COUNTER);
    }
}
