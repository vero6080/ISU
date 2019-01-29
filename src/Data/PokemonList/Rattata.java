package Data.PokemonList;

import Data.Moves.Attack.Bite;
import Data.Moves.Attack.QuickAttack;
import Data.Moves.Attack.Tackle;
import Data.Moves.Lower.TailWhip;
import Data.Pokemon;
import Data.type_t;

public class Rattata extends Pokemon{

    public Rattata(int levelArg) {
        super("Rattata", levelArg, type_t.normal, new Tackle(), new TailWhip(), new QuickAttack(), new Bite());
    }
    
}
