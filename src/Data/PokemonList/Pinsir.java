package Data.PokemonList;

import Data.Moves.Attack.Cut;
import Data.Moves.Attack.HornAttack;
import Data.Moves.Boost.SwordsDance;
import Data.Moves.Lower.StringShot;
import Data.Pokemon;
import Data.type_t;

public class Pinsir extends Pokemon{
    public Pinsir(int levelArg) {
        super("Pinsir", levelArg, type_t.grass, new SwordsDance(), new StringShot(), new HornAttack(), new Cut(), "pinsir.v1.png");
    }
}
