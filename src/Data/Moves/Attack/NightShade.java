package Data.Moves.Attack;
import Data.status_t;

//Inflicts damage equal to user's level

import Data.Attack;
import Data.Pokemon;

public class NightShade extends Attack{
    public NightShade() {
        super("NightShade", 10, status_t.none);
    }
    
    @Override
    public void use(Pokemon myPoke, Pokemon enemyPoke) {
        int accuracyVal = (int)(Math.random() * 100 + 1);
        if(accuracyVal <= myPoke.getAccuracy() - (enemyPoke.getSpeed() / 4) + (myPoke.getSpeed() / 4)) {
            if(myPoke.getLevel() > enemyPoke.getDefense() / 8) {
                enemyPoke.setHealth(enemyPoke.getHealth() - 1);
            }
            else enemyPoke.setHealth(enemyPoke.getHealth() - (myPoke.getLevel() - enemyPoke.getDefense() / 8));
        }
        else System.out.println("Missed");
        //else {missed attack}
    }
}