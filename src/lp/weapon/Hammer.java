package lp.weapon;

public class Hammer extends AbstractWeapon {
    private static int DAMAGE = 25;

    public Hammer() {
        super(DAMAGE, Rarity.EPIQUE, 200);
    }

    @Override
    public String asciiArt() {
        return "             +-+\n" +
                "=============| |\n" +
                "            `:_;'";
    }
}
