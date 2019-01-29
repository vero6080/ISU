package Data.Moves.Attack;
import Data.status_t;

import Data.Attack;

public class BlazeKick extends Attack {
    public BlazeKick() {
        super("BlazeKick", 25, status_t.burn);
    }
}
