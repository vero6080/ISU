package Data;

public abstract class Heal extends Move {
    public Heal(String nameArg, int powerArg) {
        name = nameArg;
        power = powerArg;
    }
    
    @Override
    public void use(Pokemon myPoke) {
        myPoke.setHealth(myPoke.getHealth() + power);
        if(myPoke.getHealth() > 100) myPoke.setHealth(100);
    }
    
    @Override
    public void use(Pokemon arg1, Pokemon arg2) {}
}
