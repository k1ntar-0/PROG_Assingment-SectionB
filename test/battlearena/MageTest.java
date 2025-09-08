package battlearena;

import org.junit.Test;
import static org.junit.Assert.*;

public class MageTest {

    @Test
    public void testAttack() {
        Mage mage = new Mage("Jaina", 80, 25); // create a real Mage

        // Test attack multiple times to account for randomness
        for (int i = 0; i < 100; i++) {
            int damage = mage.attack();
            // Damage should always be between 1 and magicPower (25)
            assertTrue(damage >= 1 && damage <= 25);
        }
    }

    @Test
    public void testTakeDamageAndIsAlive() {
        Mage mage = new Mage("Jaina", 80, 25);

        mage.takeDamage(30);
        assertEquals(50, mage.getHealth()); // health reduced

        mage.takeDamage(60);
        assertEquals(0, mage.getHealth()); // health cannot go below 0
        assertFalse(mage.isAlive());       // mage should now be dead
    }
}
