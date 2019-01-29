package Data.PokemonList;

import Data.Moves.Attack.KarateChop;
import Data.Moves.Attack.Tackle;
import Data.Moves.Boost.DefenseCurl;
import Data.Moves.Lower.Leer;
import Data.Pokemon;
import Data.type_t;

public class Machop extends Pokemon{
    public Machop(int levelArg) {
        super("Machop", levelArg, type_t.normal, new Leer(), new Tackle(), new KarateChop(), new DefenseCurl());
    }
}
