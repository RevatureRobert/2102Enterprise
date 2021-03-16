package ninja.tools;

public class Shuriken {
    private int damage;

    public Shuriken() {
        this.damage = 10;
    }

    public Shuriken(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
