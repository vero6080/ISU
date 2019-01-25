public class Attack {
    String name;
    int power;
    public void attack(int pokeAttack, Pokemon enemy) {
        enemy.health -= power + pokeAttack / 2;
    }
}