public class Boost {
    String name;
    public void attboost(Pokemon p){
        p.attack += 5;
    }
    
    public void defboost(Pokemon p){
        p.defense += 5;
    }
    
    public void spboost(Pokemon p){
        p.speed += 5;
    }
    
    public void accboost(Pokemon p){
        if(p.accuracy<96){
            p.accuracy += 5;
        }
        else if (p.accuracy>95 && p.accuracy<100){
            p.accuracy+=100;
        }
        else{
            
        }
    }
}
