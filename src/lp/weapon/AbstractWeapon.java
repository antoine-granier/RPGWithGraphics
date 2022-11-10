package lp.weapon;

public abstract class AbstractWeapon implements Weapon {

    private int damage;
    private final Rarity rarity;
    private final int price;

    public AbstractWeapon(int damage, Rarity rarity, int price) {
        this.damage = damage;
        this.rarity = rarity;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int makeDamage() {
        return damage;
    }

    @Override
    public abstract String asciiArt();

    @Override
    public String toString() {
        return "damage=" + damage +
                ", rarity=" + rarity;
    }
}
