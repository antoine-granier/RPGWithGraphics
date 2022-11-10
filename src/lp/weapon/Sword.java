package lp.weapon;

public class Sword extends AbstractWeapon {
    private static int DAMAGE = 15;

    public Sword() {
        super(DAMAGE, Rarity.COMMON, 100);
    }

    @Override
    public String asciiArt() {
        return "   .\n" +
                "  / \\\n" +
                "  | |\n" +
                "  | |\n" +
                "  |.|\n" +
                "  |.|\n" +
                "  |:|\n" +
                "  |:|\n" +
                "`--8--'\n" +
                "   8\n" +
                "   O";
    }
}
