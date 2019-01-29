package Data;

public abstract class Move {
    String name;
    int power;
    public abstract void use(Pokemon arg1, Pokemon arg2);
    public abstract void use(Pokemon arg1);
}
