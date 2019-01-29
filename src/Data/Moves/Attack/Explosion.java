package Data.Moves.Attack;
import Data.status_t;

//User faints upon using the move

import Data.Attack;
import Data.Pokemon;

public class Explosion extends Attack{
    public Explosion() {
        super("Explosion", 250, status_t.none);
    }
    
    @Override
    public void use(Pokemon myPoke, Pokemon enemyPoke) {
        myPoke.setHealth(0);
        enemyPoke.setHealth(0);
    }
}