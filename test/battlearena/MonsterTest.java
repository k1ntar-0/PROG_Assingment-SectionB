package battlearena;

import org.junit.Test;
import static org.junit.Assert.*;

public class MonsterTest {

    @Test
    public void testAttack() {
        Monster monster = new Monster("Orc", 60, 15);

        // Test attack multiple times because attack uses randomness
        for (int i = 0; i < 100; i++) {
            int damage = monster.attack();
            assertTrue(damage >= 1 && damage <= 15); // should be within attackPower
        }
    }

    @Test
    public void testTakeDamageAndIsAlive() {
        Monster monster = new Monster("Orc", 60, 15);

        monster.takeDamage(20);
        assertEquals(40, monster.getHealth()); // health reduced

        monster.takeDamage(50);
        assertEquals(0, monster.getHealth()); // health cannot go below 0
        assertFalse(monster.isAlive());       // monster should now be dead
    }
}
