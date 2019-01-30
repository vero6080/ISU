package Data.PokemonList;

import Data.Moves.Attack.DragonTail;
import Data.Moves.Attack.ThunderWave;
import Data.Moves.Attack.WaterGun;
import Data.Moves.Boost.Agility;
import Data.Pokemon;
import Data.type_t;

public class Dratini extends Pokemon{
    public Dratini(int levelArg) {
        super("Dratini", levelArg, type_t.water, new Agility(), new ThunderWave(), new DragonTail(), new WaterGun(), "dratini.v1.png");
    }
}
