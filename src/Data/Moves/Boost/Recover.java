package Data.Moves.Boost;
import Data.trait_t;
import Data.Pokemon;

//User recovers half its max HP

import Data.Boost;

public class Recover extends Boost {
    public Recover() {
        super("Recover", 0, trait_t.attack);
    }
    
    @Override
    public void use(Pokemon myPoke) {
        myPoke.setHealth(myPoke.getHealth() + 50);
        if (myPoke.getHealth() > 100) myPoke.setHealth(100);
    }
}

 