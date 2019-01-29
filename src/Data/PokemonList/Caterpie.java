package Data.PokemonList;

import Data.Moves.Attack.QuickAttack;
import Data.Moves.Attack.Tackle;
import Data.Moves.Boost.DefenseCurl;
import Data.Moves.Lower.StringShot;
import Data.Pokemon;
import Data.type_t;

public class Caterpie extends Pokemon{
    public Caterpie(int levelArg) {
        super("Caterpie", levelArg, type_t.grass, new Tackle(), new StringShot(), new QuickAttack(), new DefenseCurl());
    }
}
