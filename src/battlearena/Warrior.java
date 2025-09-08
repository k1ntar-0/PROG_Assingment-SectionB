
package battlearena;
/*
Student Number:10487456
Student name:Ndaedzo Given Tshiovhe
Section: B
*/
import java.util.Random;

public class Warrior extends Character {
    private int strength;

    public Warrior(String name, int health, int strength) {
        super(name, health);
        this.strength = strength;
    }

    @Override
    public int attack() {
        Random rand = new Random();
        return rand.nextInt(strength) + 1; // 1 to strength
    }
}
