package Data.PokemonList;

import Data.Moves.Attack.Pound;
import Data.Moves.Boost.DefenseCurl;
import Data.Moves.Boost.SoftBoiled;
import Data.Moves.Lower.Growl;
import Data.Pokemon;
import Data.type_t;

public class Chansey extends Pokemon{
    public Chansey(int levelArg) {
        super("Chansey", levelArg, type_t.normal, new Pound(), new Growl(), new DefenseCurl(), new SoftBoiled(), "chansey.v1.png");
    }
}
