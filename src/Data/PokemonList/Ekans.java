package Data.PokemonList;

import Data.Moves.Attack.Bite;
import Data.Moves.Attack.PoisonGas;
import Data.Moves.Attack.Tackle;
import Data.Moves.Lower.Leer;
import Data.Pokemon;
import Data.type_t;

public class Ekans extends Pokemon {
    public Ekans(int levelArg) {
        super("Ekans", levelArg, type_t.normal, new PoisonGas(), new Leer(), new Tackle(), new Bite(), "ekans.v1.png");
    }
}
