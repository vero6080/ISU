package Data.PokemonList;

import Data.Moves.Attack.Tackle;
import Data.Moves.Attack.WaterGun;
import Data.Moves.Boost.Withdraw;
import Data.Moves.Lower.TailWhip;
import Data.Pokemon;
import Data.type_t;

public class Squirtle extends Pokemon {
    
    public Squirtle(int levelArg) {
        super("Squirtle", levelArg, type_t.water, new Tackle(), new TailWhip(), new Withdraw(), new WaterGun());
    }
}
