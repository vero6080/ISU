package Data;

import java.util.ArrayDeque;
import java.util.Queue;

public class Trainer {
    private String name;
    private Queue <Pokemon> party;
    
    public Trainer(String nameArg){
        name = nameArg;
        party = new ArrayDeque<>();
    }
     
    public void addPoke(Pokemon poke) {
        party.add(poke);
        //adds to end
    }
    
    public void removePoke() {
        party.remove();
        //removes from beginning
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Queue<Pokemon> getParty() {return party;}
    public void setParty(Queue<Pokemon> party) {this.party = party;}
}