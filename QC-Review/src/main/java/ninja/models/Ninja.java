package ninja.models;

import ninja.ChakraNature;
import ninja.tools.Shuriken;

public class Ninja {
    private int health;
    private String name;
    private ChakraNature chakraNature;
    private String village;
    private Shuriken shuriken;

    public Ninja() {
    }

    public Ninja(int health) {
        this.health = health;
    }

    public Ninja(Shuriken shuriken) {
        this.shuriken = shuriken;
    }

    public Ninja(int health, String name, ChakraNature chakraNature, String village, Shuriken shuriken) {
        this.health = health;
        this.name = name;
        this.chakraNature = chakraNature;
        this.village = village;
        this.shuriken = shuriken;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChakraNature getChakraNature() {
        return chakraNature;
    }

    public void setChakraNature(ChakraNature chakraNature) {
        this.chakraNature = chakraNature;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public Shuriken getShuriken() {
        return shuriken;
    }

    public void setShuriken(Shuriken shuriken) {
        this.shuriken = shuriken;
    }

    public String attack(){
        return this.shuriken.yeet();
    }
}
