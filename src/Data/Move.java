package Data;

public abstract class Move {
    String name;
    int power;
    status_t statusModifier;
    trait_t trait;
    boolean missedAttack;
    
    public abstract void use(Pokemon arg1, Pokemon arg2);

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getPower() {return power;}
    public void setPower(int power) {this.power = power;}
    public status_t getStatusModifier() {return statusModifier;}
    public void setStatusModifier(status_t statusModifier) {this.statusModifier = statusModifier;}
    public trait_t getTrait() {return trait;}
    public void setTrait(trait_t trait) {this.trait = trait;}
    public boolean isMissedAttack() {return missedAttack;}
    public void setMissedAttack(boolean missedAttack) {this.missedAttack = missedAttack;}
}
