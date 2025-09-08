
package battlearena;
/*
Student Number:10487456
Student name:Ndaedzo Given Tshiovhe
Section: B
*/
import java.util.Random;

public class Monster extends Character {
    private int attackPower;

    public Monster(String name, int health, int attackPower) {
        super(name, health);
        this.attackPower = attackPower;
    }

    @Override
    public int attack() {
        Random rand = new Random();
        return rand.nextInt(attackPower) + 1; // 1 to attackPower
    }
}

