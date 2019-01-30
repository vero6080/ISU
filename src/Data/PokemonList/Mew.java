package Data.PokemonList;

import Data.Moves.Attack.Pound;
import Data.Moves.Attack.Swift;
import Data.Moves.Boost.Barrier;
import Data.Moves.Lower.Kinesis;
import Data.Pokemon;
import Data.type_t;

public class Mew extends Pokemon{
    public Mew(int levelArg) {
        super("Mew", levelArg, type_t.normal, new Pound(), new Swift(), new Barrier(), new Kinesis(), "mew.v1.png");
    }
}
