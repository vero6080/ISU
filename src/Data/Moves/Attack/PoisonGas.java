package Data.Moves.Attack;
import Data.status_t;

//Poisons opponent

import Data.Attack;

public class PoisonGas extends Attack{
    public PoisonGas() {
        super("PoisonGas", 0, status_t.poison);
    }
}
