package Data.PokemonList;

import Data.Moves.Attack.Absorb;
import Data.Moves.Attack.SleepPowder;
import Data.Moves.Attack.VineWhip;
import Data.Moves.Boost.Growth;
import Data.Pokemon;
import Data.type_t;

public class Tangela extends Pokemon{
    public Tangela(int levelArg) {
        super("Tangela", levelArg, type_t.grass, new Absorb(), new SleepPowder(), new VineWhip(), new Growth(), "tangela.v1.png");
    }
}
