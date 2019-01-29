package Data.PokemonList;

import Data.Moves.Attack.Splash;
import Data.Moves.Attack.Tackle;
import Data.Moves.Boost.Withdraw;
import Data.Moves.Lower.TailWhip;
import Data.Pokemon;
import Data.type_t;

public class Magikarp extends Pokemon{
    public Magikarp(int levelArg) {
        super("Magikarp", levelArg, type_t.water, new Tackle(), new Splash(), new Withdraw(), new TailWhip());
    }
}
