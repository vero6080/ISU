package Data;

public class Player {
    private String name;
    private Pokemon[] party;
    static int partyCounter;
    
    public Player() {
        name = "Player";
        party = new Pokemon[6];
        partyCounter = 0;
    }

    public void addPoke(Pokemon pokeArg) {
        if(partyCounter < 6) party[partyCounter++] = pokeArg;
    }
    
    public void healAll() {
        for(int i = 0; i < party.length; i++) {
            party[i].heal();
        }
    }
    
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Pokemon[] getParty() {return party;}
    public void setParty(Pokemon[] party) {this.party = party;}
    public static int getPartyCounter() {return partyCounter;}
    public void setPartyCounter(int partyCounter) {this.partyCounter = partyCounter;}
}
