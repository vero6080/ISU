package Data;

public abstract class Lower extends Move{
    public Lower(String nameArg, int powerArg, trait_t traitArg) {
        name = nameArg;
        power = powerArg;
        trait = traitArg;
    }

    @Override
    public void use(Pokemon myPoke, Pokemon enemyPoke) {
        switch (trait) {
            case attack:
                enemyPoke.setAttack(enemyPoke.getAttack() - power);
                if(enemyPoke.getAttack() < 1) enemyPoke.setAttack(1);
                break;
            case defense:
                enemyPoke.setDefense(enemyPoke.getDefense() - power);
                if(enemyPoke.getDefense() < 1) enemyPoke.setDefense(1);
                break;
            case speed:
               enemyPoke.setSpeed(enemyPoke.getSpeed() - power);
               if(enemyPoke.getSpeed() < 1) enemyPoke.setSpeed(1);
                break;
            case accuracy:
                enemyPoke.setAccuracy(enemyPoke.getAccuracy() - power);
                if(enemyPoke.getAccuracy() < 1) enemyPoke.setAccuracy(1);
                break;
        }
    }
}
