package Data;

import javax.swing.ImageIcon;

public abstract class Pokemon {
    /*
    - 5 varied properties
    - 2 constructors
    - 2 final methods
    - 1 abstract method
    - 1 regualar method
    - 1 static variable
    - 1 static method (to return static variable)
    */
    
    protected String name;
    protected type_t type;
    protected status_t status; 
    protected int level, xp, xpMax;
    protected int attack, defense, health, speed, accuracy;
    protected int baseAttack, baseDefense, baseHealth, baseSpeed, baseAccuracy;
    protected int statusCount;
    protected Move[] move = new Move[4];
    protected ImageIcon image;

    //Getters
    public String getName() {return name;}
    public type_t getType() {return type;}
    public status_t getStatus() {return status;}
    public int getStatusCount() {return statusCount;}
    public int getLevel() {return level;}
    public int getXp() {return xp;}
    public int getXpMax() {return xpMax;}
    public int getAttack() {return attack;}
    public int getDefense() {return defense;}
    public int getHealth() {return health;}
    public int getSpeed() {return speed;}
    public int getAccuracy() {return accuracy;}
    public int getBaseAttack() {return baseAttack;}
    public int getBaseDefense() {return baseDefense;}
    public int getBaseHealth() {return baseHealth;}
    public int getBaseSpeed() {return baseSpeed;}
    public int getBaseAccuracy() {return baseAccuracy;}
    public Move[] getMove() {return move;}
    public ImageIcon getImage() {return image;}
    
    //Setters
    public void setName(String name) {this.name = name;}
    public void setType(type_t type) {this.type = type;}
    public void setStatus(status_t status) {this.status = status;}
    public void setStatusCount(int statusCount) {this.statusCount = statusCount;}
    public void setLevel(int level) {this.level = level;}
    public void setXp(int xp) {this.xp = xp;}
    public void setXpMax(int xpMax) {this.xpMax = xpMax;}
    public void setAttack(int attack) {this.attack = attack;}
    public void setDefense(int defense) {this.defense = defense;}
    public void setHealth(int health) {this.health = health;}
    public void setSpeed(int speed) {this.speed = speed;}
    public void setAccuracy(int accuracy) {this.accuracy = accuracy;}
    public void setBaseAttack(int baseAttack) {this.baseAttack = baseAttack;}
    public void setBaseDefense(int baseDefense) {this.baseDefense = baseDefense;}
    public void setBaseHealth(int baseHealth) {this.baseHealth = baseHealth;}
    public void setBaseSpeed(int baseSpeed) {this.baseSpeed = baseSpeed;}
    public void setBaseAccuracy(int baseAccuracy) {this.baseAccuracy = baseAccuracy;}
    public void setMove(Move[] move) {this.move = move;}
    public void setImage(ImageIcon image) {this.image = image;}
    
    public Pokemon(String nameArg, int levelArg, type_t typeArg, Move m0, Move m1, Move m2, Move m3) {
        name = nameArg;
        type = typeArg;
        status = status_t.none;
        health = 100;
        xp = 0;
        xpMax = levelArg * 10;
        baseAttack = attack = baseDefense = defense = baseSpeed = speed = level = levelArg;
        baseAccuracy = accuracy = levelArg * 2;
        if(accuracy > 100) {
            baseAccuracy = accuracy = 100;
        }
        statusCount = 0;
        move[0] = m0;
        move[1] = m1;
        move[2] = m2;
        move[3] = m3;
    }
    
    public void enforceStatus() {
        switch (status) {
            case poison:
                health -= 5;
                break;
            case burn:
                health -= 10;
                break;
        }
        statusCount--;
        if(statusCount < 1) status = status_t.none;
    }
    
    public final void levelUp() {
        level++;
        xp = 0;
        baseAttack += 5;
        baseDefense += 5;
        baseSpeed += 5;
        baseAccuracy += 5;
        if(level > 100) level = 100;
        else xpMax *= 2;
        if(baseAttack > 100) baseAttack = 100;
        if(baseDefense > 100) baseDefense = 100;
        if(baseSpeed > 100) baseSpeed = 100;
        if(baseAccuracy > 100) baseAccuracy = 100;
    }
    
    public final void heal() {
        health = 100;
        attack = baseAttack;
        defense = baseDefense;
        speed = baseSpeed;
        accuracy = baseAccuracy;
    }
    
    public final void addXp(int xpArg) {
        xp += xpArg;
        if(xp >= xpMax) levelUp();
    }
}