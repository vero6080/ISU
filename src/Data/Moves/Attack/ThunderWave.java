package Data.Moves.Attack;
import Data.status_t;

//Paralyzes opponent

import Data.Attack;

public class ThunderWave extends Attack{
    public ThunderWave() {
        super("ThunderWave", 0, status_t.paralyze);
    }
}
