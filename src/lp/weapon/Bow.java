package lp.weapon;

public class Bow extends AbstractWeapon {
    private static int DAMAGE = 25;

    public Bow() {
        super(DAMAGE, Rarity.COMMON, 100);
    }

    @Override
    public String asciiArt() {
        return "  (\n" +
                "    \\\n" +
                "     )\n" +
                "##-------->\n" +
                "     )\n" +
                "    /\n" +
                "   (";
    }
}
