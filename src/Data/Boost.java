package Data;

public abstract class Boost extends Move {
    private trait_t trait;
    public Boost(String nameArg, int powerArg, trait_t traitArg) {
        name = nameArg;
        power = powerArg;
        trait = traitArg;
    }

    @Override
    public void use(Pokemon myPoke) {
        switch (trait) {
            case attack:
                myPoke.setAttack(myPoke.getAttack() + power);
                if(myPoke.getAttack() > 100) myPoke.setAttack(100);
                break;
            case defense:
                myPoke.setDefense(myPoke.getDefense() + power);
                if(myPoke.getDefense() > 100) myPoke.setDefense(100);
                break;
            case speed:
               myPoke.setSpeed(myPoke.getSpeed() + power);
               if(myPoke.getSpeed() > 100) myPoke.setSpeed(100);
                break;
            case accuracy:
                myPoke.setAccuracy(myPoke.getAccuracy() + power);
                if(myPoke.getAccuracy() > 100) myPoke.setAccuracy(100);
                break;
        }
    }
    
    @Override
    public void use(Pokemon arg1, Pokemon arg2) {}
}
