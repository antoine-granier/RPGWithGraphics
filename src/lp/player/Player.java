package lp.player;

import lp.stats.Stats;
import lp.weapon.Bow;
import lp.weapon.EvilStick;
import lp.weapon.Sword;
import lp.weapon.Weapon;

import java.util.ArrayList;

public class Player {
    private String name;
    private int gold;
    private int maxHp;
    private int hp;
    private final String cast;
    private Weapon actualWeapon;
    private final ArrayList<Weapon> inventory;
    private Stats stats;

    public Player(String name, int gold, int maxHp, String cast) {
        this.name = name;
        this.gold = gold;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.cast = cast;
        this.inventory = new ArrayList<Weapon>();
        this.stats = new Stats();
        initInventory();
    }

    public void takeDamage(int damage) {
        hp -= damage;
    }

    public void heal(int healPoint) {
        hp += healPoint;
        if(hp > maxHp) {
            hp = maxHp;
        }
    }

    public boolean isDead() {
        if(hp <= 0) {
            return true;
        }
        return false;
    }

    public boolean haveNecessaryMoney(int price) {
        if(gold >= price) {
            return true;
        }
        return false;
    }

    public void addToInventory(Weapon weapon) {
        inventory.add(weapon);
        gold -= weapon.getPrice();
    }

    public Stats getStats() {
        return stats;
    }

    public int makeDamage() {
        return actualWeapon.makeDamage();
    }

    public void endFight() {
        stats = new Stats();
    }

    public void initInventory() {
        switch (cast) {
            case "Barbarian":
                inventory.add(new Sword());
                break;
            case "Wizard":
                inventory.add(new EvilStick());
                break;
            case "Archery":
                inventory.add(new Bow());
                break;
            default:
                throw new IllegalStateException("Problem in player creation");
        }
    }

    public ArrayList<Weapon> getInventory() {
        return inventory;
    }

    public void changeWeapon(int index) {
        actualWeapon = inventory.get(index);
    }

    public String getCast() {
        return cast;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", gold=" + gold +
                ", maxHp=" + maxHp +
                ", hp=" + hp +
                ", cast='" + cast + '\'' +
                ", inventory=" + inventory +
                '}';
    }

    public void giveReward(int reward) {
        gold += reward;
    }
}
