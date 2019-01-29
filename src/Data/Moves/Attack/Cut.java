package Data.Moves.Attack;
import Data.status_t;

import Data.Attack;

public class Cut extends Attack{
    public Cut() {
        super("Cut", 10, status_t.none);
    }
}
