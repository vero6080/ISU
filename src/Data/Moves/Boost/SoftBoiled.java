package Data.Moves.Boost;
import Data.trait_t;
import Data.Pokemon;

//User recovers half its max HP

import Data.Heal;

public class SoftBoiled extends Heal {
    public SoftBoiled() {
        super("SoftBoiled", 0);
    }
    
    @Override
    public void use(Pokemon myPoke, Pokemon enemyPoke) {
        myPoke.setHealth(myPoke.getHealth() + 50);
        if (myPoke.getHealth() > 100) myPoke.setHealth(100);
    }
}
