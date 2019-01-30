package Data.PokemonList;
import Data.Moves.Boost.TailGlow;
import Data.Moves.Attack.Tackle;
import Data.Moves.Lower.Screech;
import Data.Moves.Attack.BlazeKick;
import Data.Pokemon;
import Data.type_t;

    public class Charmander extends Pokemon {
    
    public Charmander(int levelArg) {
        super("Charmander", levelArg, type_t.fire, new Tackle(), new BlazeKick(), new TailGlow(), new Screech(), "charmander.v1.png");
    }
    
    public Charmander(int levelArg, int attackArg, int defenseArg, int speedArg, int accuracyArg) {
        super("Charmander", levelArg, type_t.fire, attackArg, defenseArg, speedArg, accuracyArg, new Tackle(), new BlazeKick(), new TailGlow(), new Screech(), "charmander.v1.png");
    }
    
    public void Message() {
        System.out.println("Hello! My name is Charmander.");
    }
}
