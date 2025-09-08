
package battlearena;
/*
Student Number:10487456
Student name:Ndaedzo Given Tshiovhe
Section: B
*/
public class Character {
    private String name;
    private int health;

    public Character(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public void setHealth(int health) { this.health = health; }

    public boolean isAlive() { return health > 0; }

    public void takeDamage(int damage) {
        health -= damage;
        if(health < 0) health = 0;
    }

    public int attack() {
        return 0; // To be overridden
    }
}
