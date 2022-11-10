package lp.weapon;

public class DemonicCross extends AbstractWeapon {
    public static int DAMAGE = 25;

    public DemonicCross() {
        super(DAMAGE, Rarity.RARE, 260);
    }

    @Override
    public String asciiArt() {
        return " __\n" +
                "/_/\\/\\\n" +
                "\\_\\  /\n" +
                "/_/  \\\n" +
                "\\_\\/\\ \\\n" +
                "   \\_\\/";
    }
}
