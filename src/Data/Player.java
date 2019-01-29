package Data;

public class Player {
    private String name;
    private final Pokemon[] party;
    int partyCounter;
    
    public Player() {
        name = "Player";
        party = new Pokemon[6];
        partyCounter = 0;
    }

    void addPoke(Pokemon pokeArg) {
        if(partyCounter < 6) party[partyCounter++] = pokeArg;
    }
    
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
