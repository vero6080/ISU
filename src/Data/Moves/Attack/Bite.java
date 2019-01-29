package Data.Moves.Attack;

import Data.Attack;
import Data.status_t;

public class Bite extends Attack{
    public Bite() {
        super("Bite", 25, status_t.none);
    }
}
