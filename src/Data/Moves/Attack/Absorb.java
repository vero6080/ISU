package Data.Moves.Attack;
import Data.status_t;

//User aborbs health equal to half the damage the oppontent takes

import Data.Attack;
import Data.Pokemon;

public class Absorb extends Attack{
    public Absorb() {
        super("Absorb", 20, status_t.none);
    }
    
    @Override
    public void use(Pokemon myPoke, Pokemon enemyPoke) {
        int accuracyVal = (int)(Math.random() * 100 + 1);
        if(accuracyVal <= myPoke.getAccuracy() - (enemyPoke.getSpeed() / 4) + (myPoke.getSpeed() / 4)) {
            if(20 + myPoke.getAttack() / 4 <= enemyPoke.getDefense() / 8) {
                enemyPoke.setHealth(enemyPoke.getHealth() - 1);
                myPoke.setHealth(myPoke.getHealth() + 1);
            }
            else {
                int tempDamage = ((20 + myPoke.getAttack() / 4) - enemyPoke.getDefense() / 8);
                enemyPoke.setHealth(enemyPoke.getHealth() - tempDamage);
                myPoke.setHealth(myPoke.getHealth() + tempDamage / 2);
            }
            if(myPoke.getHealth() > 100) myPoke.setHealth(100);
        }
        else System.out.println("Missed");
        //else {missed attack}
    }
}