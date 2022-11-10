package lp.weapon;

public class Crossbow extends AbstractWeapon {
    public static int DAMAGE = 30;

    public Crossbow() {
        super(DAMAGE, Rarity.RARE, 210);
    }

    @Override
    public String asciiArt() {
        return "     .-.\n" +
                "               /  \\\\\n" +
                "          .---/-+--||\n" +
                "          |  K=====++->\n" +
                "          '---\\-+--||\n" +
                "               \\  //\n" +
                "                `-'";
    }
}
