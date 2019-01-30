package Data.PokemonList;

import Data.Moves.Attack.QuickAttack;
import Data.Moves.Attack.ThunderShock;
import Data.Moves.Attack.ThunderWave;
import Data.Moves.Lower.Leer;
import Data.Pokemon;
import Data.type_t;

public class Electabuzz extends Pokemon{
    public Electabuzz(int levelArg) {
        super("Electrabuzz", levelArg, type_t.electric, new ThunderShock(), new Leer(), new QuickAttack(), new ThunderWave(), "electabuzz.v1.png");
    }
}
