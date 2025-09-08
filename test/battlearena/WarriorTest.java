package battlearena;

import org.junit.Test;
import static org.junit.Assert.*;

public class WarriorTest {

    @Test
    public void testAttack() {
        Warrior warrior = new Warrior("Arthas", 100, 20);

        // Test attack multiple times due to randomness
        for (int i = 0; i < 100; i++) {
            int damage = warrior.attack();
            assertTrue(damage >= 1 && damage <= 20); // damage within strength
        }
    }

    @Test
    public void testTakeDamageAndIsAlive() {
        Warrior warrior = new Warrior("Arthas", 100, 20);

        warrior.takeDamage(30);
        assertEquals(70, warrior.getHealth()); // health reduced correctly

        warrior.takeDamage(100);
        assertEquals(0, warrior.getHealth()); // health cannot go negative
        assertFalse(warrior.isAlive());       // should be dead
    }
}
