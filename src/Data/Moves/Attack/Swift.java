package Data.Moves.Attack;

import Data.Attack;
import Data.Pokemon;
import Data.status_t;

//This attack never misses
public class Swift extends Attack {
    public Swift() {
        super("Swift", 26, status_t.none);
    }
    
    @Override
    public void use(Pokemon myPoke, Pokemon enemyPoke) {
        if(26 + myPoke.getAttack() / 4 <= enemyPoke.getDefense() / 8) {
            enemyPoke.setHealth(enemyPoke.getHealth() - 1);
        }
        else enemyPoke.setHealth(enemyPoke.getHealth() - ((26 + myPoke.getAttack() / 4) - enemyPoke.getDefense() / 8));
    }
}

