package Data;

public abstract class Attack extends Move {
    status_t statusModifier;
    public Attack(String nameArg, int powerArg, status_t statusArg) {
        name = nameArg;
        power = powerArg;
        statusModifier = statusArg;
    }
    
    @Override
    public void use(Pokemon myPoke, Pokemon enemyPoke) {
        //Determine if the attack will hit.
        int accuracyVal = (int)(Math.random() * 100 + 1);
        if(accuracyVal <= myPoke.getAccuracy() - (enemyPoke.getSpeed() / 4) + (myPoke.getSpeed() / 4)) {
            //Apply status modifier to pokemon.
            if(statusModifier != status_t.none)  {
                myPoke.setStatus(statusModifier);
                myPoke.setStatusCount(3);
            }
            //Determine type damage bonus.
            int typeDamage = 0;
            switch(myPoke.getType()) {
                case normal:
                    if(enemyPoke.getType() == type_t.electric) typeDamage = 6;
                    break;
                case water:
                    if(enemyPoke.getType() == type_t.fire) typeDamage = 6;
                    break;
                case fire:
                    if(enemyPoke.getType() == type_t.grass) typeDamage = 6;
                    break;
                case grass:
                    if(enemyPoke.getType() == type_t.water) typeDamage = 6;
                    break;
                case electric:
                    if(enemyPoke.getType() == type_t.water) typeDamage = 6;
                    break;
            }
            //Check if damage inflicted is higher than the enemies defense.
            if(power + typeDamage + myPoke.getAttack() / 4 > enemyPoke.getDefense() / 8) {
                //Attack the enemy.
                enemyPoke.setHealth(enemyPoke.getHealth() - ((power + typeDamage + myPoke.getAttack() / 4) - enemyPoke.getDefense() / 8));
                //Add xp to player's pokemon.
                myPoke.addXp(((power + typeDamage + myPoke.getAttack() / 4) - enemyPoke.getDefense() / 8) / 2);
            }
        }
        else System.out.println("Missed");
        //else {missed attack}
    }
    
    @Override
    public  void use(Pokemon arg1) {}
}