package simulation.Entitys;

public class Predator extends Creature{
    private int attackPower;

    public Predator(Type type) {
        super(type);
    }

    @Override
    public void makeMove() {
        // TODO переместиться или атаковать(herbivore)
    }
}
