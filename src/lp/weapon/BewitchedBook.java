package lp.weapon;

public class BewitchedBook extends AbstractWeapon {
    private static int DAMAGE = 30;

    public BewitchedBook() {
        super(DAMAGE, Rarity.EPIQUE, 300);
    }

    @Override
    public String asciiArt() {
        return "      ______ ______\n" +
                "    _/      Y      \\_\n" +
                "   // ~~ ~~ | ~~ ~  \\\\\n" +
                "  // ~ ~ ~~ | ~~~ ~~ \\\\\n" +
                " //________.|.________\\\\\n" +
                "`----------`-'----------'";
    }
}
