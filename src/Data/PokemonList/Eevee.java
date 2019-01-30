package Data.PokemonList;

import Data.Moves.Attack.QuickAttack;
import Data.Moves.Attack.Tackle;
import Data.Moves.Lower.Growl;
import Data.Moves.Lower.TailWhip;
import Data.Pokemon;
import Data.type_t;

public class Eevee extends Pokemon{
    public Eevee(int levelArg) {
        super("Eevee", levelArg, type_t.normal, new Tackle(), new Growl(), new QuickAttack(), new TailWhip(), "eevee.v1.png");
    }
}
