package battlearena;

import org.junit.Test;
import static org.junit.Assert.*;

public class CharacterTest {

    @Test
    public void testGetName() {
        Character w = new Warrior("Arthas", 100, 20);
        assertEquals("Arthas", w.getName());

        Character m = new Mage("Jaina", 80, 25);
        assertEquals("Jaina", m.getName());
    }

    @Test
    public void testGetAndSetHealth() {
        Warrior w = new Warrior("Arthas", 100, 20);
        assertEquals(100, w.getHealth());

        w.setHealth(50);
        assertEquals(50, w.getHealth());
    }

    @Test
    public void testIsAlive() {
        Mage m = new Mage("Jaina", 50, 25);
        assertTrue(m.isAlive());

        m.takeDamage(50);
        assertFalse(m.isAlive());
    }

    @Test
    public void testTakeDamage() {
        Warrior w = new Warrior("Arthas", 100, 20);
        w.takeDamage(30);
        assertEquals(70, w.getHealth());

        w.takeDamage(100); // health should not go negative
        assertEquals(0, w.getHealth());
    }

    @Test
    public void testAttackWithinRange() {
        Warrior w = new Warrior("Arthas", 100, 20);
        for (int i = 0; i < 100; i++) {
            int dmg = w.attack();
            assertTrue(dmg >= 1 && dmg <= 20);
        }

        Mage m = new Mage("Jaina", 80, 25);
        for (int i = 0; i < 100; i++) {
            int dmg = m.attack();
            assertTrue(dmg >= 1 && dmg <= 25);
        }

        Monster mon = new Monster("Orc", 60, 15);
        for (int i = 0; i < 100; i++) {
            int dmg = mon.attack();
            assertTrue(dmg >= 1 && dmg <= 15);
        }
    }
}
