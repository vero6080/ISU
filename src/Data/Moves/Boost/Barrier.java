package Data.Moves.Boost;
import Data.trait_t;

//Sharply raises user's Defense

import Data.Boost;

public class Barrier extends Boost{
    public Barrier() {
        super("Barrier", 60, trait_t.defense);
    }
}
