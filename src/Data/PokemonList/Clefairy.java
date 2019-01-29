package Data.PokemonList;

import Data.Moves.Attack.Pound;
import Data.Moves.Attack.Swift;
import Data.Moves.Boost.DefenseCurl;
import Data.Moves.Lower.Growl;
import Data.Pokemon;
import Data.type_t;

public class Clefairy extends Pokemon{
    public Clefairy(int levelArg) {
        super("Clefairy", levelArg, type_t.normal, new Growl(), new DefenseCurl(), new Swift(), new Pound());
    }
}
