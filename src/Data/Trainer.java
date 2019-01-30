package Data;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.HashMap;

public class Trainer {
    private String name;
    private Queue <Pokemon> party;
    private final Stack <moveType_t> AIStack;
    
    public Trainer(String nameArg){
        name = nameArg;
        party = new ArrayDeque<>();
        AIStack = new Stack<>();
    }
     
    public void addPoke(Pokemon poke) {
        party.add(poke);
        //adds to end
    }
    
    public void removePoke() {
        party.remove();
        //removes from beginning
    }
    
    //UNUSED
    public Move determineAction(Pokemon playerPoke) {
        //Create a hashmap of the AI's current moveset.
        HashMap<Move, moveType_t> moveMap = new HashMap<>();
        for(int i = 0; i < party.peek().getMove().length; i++) {
            if(party.peek().getMove()[i] instanceof Attack) moveMap.put(party.peek().getMove()[i], moveType_t.Attack);
            else if(party.peek().getMove()[i] instanceof Boost) moveMap.put(party.peek().getMove()[i], moveType_t.Boost);
            else if(party.peek().getMove()[i] instanceof Lower) moveMap.put(party.peek().getMove()[i], moveType_t.Lower);
            else if(party.peek().getMove()[i] instanceof Heal) moveMap.put(party.peek().getMove()[i], moveType_t.Heal);
        }
        //Check for immediate actions in order of importance (least to greatest) and add them to the stack.
        AIStack.clear();
        if(playerPoke.getHealth() < 30) AIStack.add(moveType_t.Attack);
        if(party.peek().getHealth() < 30) AIStack.add(moveType_t.Heal);
        //Choose action based on the most important flag (only if the AI can do it).
        moveType_t topAction = null;
        if(!AIStack.isEmpty()) { 
            //While a matching move type is not found and the stack is not empty: continue to pop off the stack.
            do topAction = AIStack.pop();
            while(!moveMap.containsValue(topAction) && !AIStack.isEmpty());
            //If a matching move type is found, find the first move in the map of that type.
            if(moveMap.containsValue(topAction)) {
                for(int i = 0; i < party.peek().getMove().length; i++) {
                    if(moveMap.get(party.peek().getMove()[i]) == topAction) {
                        return party.peek().getMove()[i];
                    }
                }
            }
        }
        //If a matching move type is not found or the stack is empty, pick a random move from the moveset,
        //(means there is no immediate/important action, or the AI doesn't have any helpful moves in it's moveset).
        int randVal = (int)(Math.random() * party.peek().getMove().length);
        return party.peek().getMove()[randVal];
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Queue<Pokemon> getParty() {return party;}
    public void setParty(Queue<Pokemon> party) {this.party = party;}
}