package Data.PokemonList;

import Data.Moves.Attack.BlazeKick;
import Data.Moves.Attack.Ember;
import Data.Moves.Lower.Leer;
import Data.Moves.Lower.SmokeScreen;
import Data.Pokemon;
import Data.type_t;

public class Magmar extends Pokemon{
    public Magmar(int levelArg) {
        super("Magmar", levelArg, type_t.fire, new Leer(), new SmokeScreen(), new BlazeKick(), new Ember(), "magmar.v1.png");
    }
}
