
package battlearena;
/*
Student Number:10487456
Student name:Ndaedzo Given Tshiovhe
Section: B
*/
public class BattleArena {
    public static void main(String[] args) {
        // Create heroes
        Character[] heroes = new Character[2];
        heroes[0] = new Warrior("Arthas", 100, 20);
        heroes[1] = new Mage("Jaina", 80, 25);

        // Create monsters
        Character[] monsters = new Character[2];
        monsters[0] = new Monster("Goblin", 50, 15);
        monsters[1] = new Monster("Orc", 70, 20);

        // 2D array for battle logs [heroes][monsters]
        int[][] battleLog = new int[heroes.length][monsters.length];

        // Battle loop
        for(int i=0; i<heroes.length; i++) {
            for(int j=0; j<monsters.length; j++) {
                if(heroes[i].isAlive() && monsters[j].isAlive()) {
                    int heroAttack = heroes[i].attack();
                    monsters[j].takeDamage(heroAttack);
                    battleLog[i][j] = heroAttack;

                    if(monsters[j].isAlive()) {
                        int monsterAttack = monsters[j].attack();
                        heroes[i].takeDamage(monsterAttack);
                    }
                }
            }
        }

        // Report
        System.out.println("=== Battle Report ===");
        for(int i=0; i<heroes.length; i++) {
            System.out.println(heroes[i].getName() + " remaining health: " + heroes[i].getHealth());
            for(int j=0; j<monsters.length; j++) {
                System.out.println("  Attack on " + monsters[j].getName() + ": " + battleLog[i][j] + " damage");
            }
        }

        System.out.println("\nMonsters remaining health:");
        for(Character m : monsters) {
            System.out.println(m.getName() + ": " + m.getHealth());
        }
    }
}
