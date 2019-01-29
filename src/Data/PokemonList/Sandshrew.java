
package Data.PokemonList;

import Data.Moves.Attack.Scratch;
import Data.Moves.Attack.Swift;
import Data.Moves.Boost.DefenseCurl;
import Data.Moves.Lower.SandAttack;
import Data.Pokemon;
import Data.type_t;

public class Sandshrew extends Pokemon {
    public Sandshrew(int levelArg) {
        super("Sandshrew", levelArg, type_t.grass, new DefenseCurl(), new SandAttack(), new Swift(), new Scratch());
    }
}
