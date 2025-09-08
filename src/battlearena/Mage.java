
package battlearena;
/*
Student Number:10487456
Student name:Ndaedzo Given Tshiovhe
Section: B
*/
import java.util.Random;

public class Mage extends Character {
    private int magicPower;

    public Mage(String name, int health, int magicPower) {
        super(name, health);
        this.magicPower = magicPower;
    }

    @Override
    public int attack() {
        Random rand = new Random();
        return rand.nextInt(magicPower) + 1; // 1 to magicPower
    }
}

