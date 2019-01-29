package Data.Moves.Boost;
import Data.trait_t;

//Raises user's Attack

import Data.Boost;

public class Sharpen extends Boost {
    public Sharpen() {
        super("Sharpen", 20, trait_t.attack);
    }
}