package Data.Moves.Attack;
import Data.status_t;

//Puts opponent to sleep

import Data.Attack;

public class SleepPowder extends Attack{
    public SleepPowder() {
        super("SleepPowder", 0, status_t.sleep);
    }
}
