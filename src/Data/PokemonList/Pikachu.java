package Data.PokemonList;

import Data.Moves.Attack.QuickAttack;
import Data.Moves.Attack.ThunderShock;
import Data.Moves.Attack.ThunderWave;
import Data.Moves.Lower.TailWhip;
import Data.Pokemon;
import Data.type_t;

public class Pikachu extends Pokemon{
    public Pikachu(int levelArg) {
        super("Pikachu", levelArg, type_t.electric, new TailWhip(), new ThunderWave(), new ThunderShock(), new QuickAttack(), "pikachu.v1.png");
    }
}
