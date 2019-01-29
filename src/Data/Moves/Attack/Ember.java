package Data.Moves.Attack;

import Data.Attack;
import Data.status_t;

//Has a chance to burn the opponent's pokemon
public class Ember extends Attack{
    public Ember() {
        super("Ember", 30, status_t.burn);
    }
}
