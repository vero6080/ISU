
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
    
    enum status_t {none, poison, burn, freeze, sleep, paralyze, confuse}  
    enum type_t {water, fire, grass, ice, electric, rock}
    
    protected String name;
    protected type_t type;
    protected status_t status;
    protected int level, xp, xpmax;
    protected int attack, defense, health, speed;
    protected int accuracy;
    protected ImageIcon image;
    
    public Pokemon(){
        status = status_t.none;
        level = 5;
    }
    
    public Pokemon(String n, int l){
        status = status_t.none;
        level = l;
    }
    
    public final void levelUp(){
        if(xp==xpmax){
            level++;
        }
    }
}