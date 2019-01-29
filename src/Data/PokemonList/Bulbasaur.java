package Data.PokemonList;

import Data.Moves.Attack.SleepPowder;
import Data.Moves.Attack.Tackle;
import Data.Moves.Attack.VineWhip;
import Data.Moves.Lower.Growl;
import Data.Pokemon;
import Data.type_t;

public class Bulbasaur extends Pokemon {
    
    public Bulbasaur(int levelArg) {
        super("Bulbasaur", levelArg, type_t.grass, new Tackle(), new Growl(), new SleepPowder(), new VineWhip());
    }
    
}
