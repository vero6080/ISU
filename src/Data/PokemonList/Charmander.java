package Data.PokemonList;
import Data.Moves.Boost.TailGlow;
import Data.Moves.Attack.Tackle;
import Data.Moves.Lower.Screech;
import Data.Moves.Attack.BlazeKick;
import Data.Pokemon;
import Data.type_t;

    public class Charmander extends Pokemon {
    /*
    - 1 additional property
    - 1 additional ability (exlusive method)
    - 2 consructors (both call the parent)
    - Implementation of abstract method
    - Override/extend the regular method for Parent class
    */
    
    public Charmander(int levelArg) {
        super("Charmander", levelArg, type_t.fire, new Tackle(), new BlazeKick(), new TailGlow(), new Screech());
    }
}
