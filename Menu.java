package CloneSim;

import java.util.Scanner;

public class Menu {
    public static final String START = "s";
    public static final String NEXT_TURN = "n";
    public static final String PAUSE = "p";
    public static final String RESUME = "r";
    public static final String QUIT = "q";
    public static final String welcomeMessage = ("Приветствую тебя в симуляции\n" +
            "вводи букву и нажимай enter\n" +
            "s - запустить бесконечную симуляцию\n" +
            "n - следующий ход\n" +
            "p - приостановить симуляцию\n" +
            "r - продолжить симуляцию\n" +
            "q - выход");
    private final Simulation simulation;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(Simulation simulation) {
        this.simulation = simulation;
    }

    public void start() {
        System.out.println(welcomeMessage);
        while (true) {
            String userInput = scanner.nextLine().toLowerCase();

            switch (userInput) {
                case START:
                    simulation.startSimulation();
                    break;

                case NEXT_TURN:
                    simulation.nextTurn();

                case PAUSE:
                    simulation.pauseSimulation();
                    break;

                case RESUME:
                    System.out.println("Продолжаем симуляцию");
                    simulation.resumeSimulation();
                    break;

                case QUIT:
                    simulation.pauseSimulation();
                    System.out.println("Выход из симуляции...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Недопустимый ввод. Пожалуйста, введите 's', 'p', 'r' или 'q'.");
            }
        }
    }
}
