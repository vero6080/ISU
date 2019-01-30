package Data.PokemonList;

import Data.Moves.Attack.Bite;
import Data.Moves.Attack.Scratch;
import Data.Moves.Lower.Growl;
import Data.Moves.Lower.TailWhip;
import Data.Pokemon;
import Data.type_t;

public class Nidoran extends Pokemon{
    public Nidoran(int levelArg) {
        super("Nidoran", levelArg, type_t.electric, new Growl(), new TailWhip(), new Bite(), new Scratch(), "nidoran.v1.png");
    }
}
