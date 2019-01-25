import java.util.ArrayDeque;
import java.util.Queue;

public class Trainer {
    private String name;
    private Queue <Pokemon> party;
    
    public Trainer(String n){
        name = n;
        party = new ArrayDeque<>();
    }
    
    public void addPokemon(Pokemon poke) {
        party.add(poke);
    }
}