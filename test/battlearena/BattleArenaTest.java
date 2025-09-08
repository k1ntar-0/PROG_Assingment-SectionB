package battlearena;

import org.junit.Test;
import static org.junit.Assert.*;

public class BattleArenaTest {

    @Test
    public void testBattleOutcome() {
        // Setup: heroes
        Character[] heroes = new Character[] {
            new Warrior("Arthas", 50, 20),  // Low health to test survival
            new Mage("Jaina", 60, 25)
        };

        // Setup: monsters
        Character[] monsters = new Character[] {
            new Monster("Goblin", 40, 10),
            new Monster("Orc", 50, 15)
        };

        // Battle log: [hero][monster]
        int[][] battleLog = new int[heroes.length][monsters.length];

        // Simulate battle rounds until all monsters or heroes are dead
        boolean heroesAlive = true;
        boolean monstersAlive = true;

        while (heroesAlive && monstersAlive) {
            heroesAlive = false;
            monstersAlive = false;

            // Heroes attack
            for (int i = 0; i < heroes.length; i++) {
                if (!heroes[i].isAlive()) continue;
                heroesAlive = true;

                for (int j = 0; j < monsters.length; j++) {
                    if (!monsters[j].isAlive()) continue;
                    monstersAlive = true;

                    int damage = heroes[i].attack();
                    monsters[j].takeDamage(damage);
                    battleLog[i][j] += damage; // accumulate damage

                    // Monster retaliates
                    if (monsters[j].isAlive()) {
                        int mDamage = monsters[j].attack();
                        heroes[i].takeDamage(mDamage);
                    }
                }
            }
        }

        // Check that battle ends properly
        boolean anyHeroAlive = false;
        for (Character h : heroes) {
            if (h.isAlive()) {
                anyHeroAlive = true;
            }
        }

        boolean anyMonsterAlive = false;
        for (Character m : monsters) {
            if (m.isAlive()) {
                anyMonsterAlive = true;
            }
        }

        // Assert that at least one side has died
        assertFalse(anyHeroAlive && anyMonsterAlive);

        // Optional: print summary for debug
        System.out.println("=== Battle Summary ===");
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getName() + " remaining health: " + heroes[i].getHealth());
            for (int j = 0; j < monsters.length; j++) {
                System.out.println("  Damage to " + monsters[j].getName() + ": " + battleLog[i][j]);
            }
        }
        for (Character m : monsters) {
            System.out.println(m.getName() + " remaining health: " + m.getHealth());
        }
    }
}
